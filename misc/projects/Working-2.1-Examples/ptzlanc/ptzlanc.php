<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>BYU PHDL Project - ptzlanc.phdl</title>
<?php include("../../../links.php")?>
<?php include("../../../prettify.php")?>

</head>
<body onload="prettyPrint()">

	<pre class="prettyprint lang-phdl linenums" title="ptzlanc.phdl">
/**
 * Pan-tilt-zoom LANC controller for Small HD Sony video cameras
 * Author: Brad Riching
 */

// 3.6mm mounting hole
device 3mm6_hole {
	attr REFPREFIX = "H";
	attr FOOTPRINT = "3,6";
	attr LIBRARY = "holes";
}

design ptzlanc {

// power supply
	net vmot, vdd, vu, vcco, vccaux, vccint, gnd; // &lt;= 40V, 12V, 5V, 3.3V, 2.5V, 1.2V, 0V respectively
	net 3v3_sense, 5v_pwr, 3v3_pwr, 2v5_pwr;

	// global clock and reset
	net clk, rst, reset_res;
	// serial rs232 receive and transmit
	net rxd, txd, rxd_a, txd_a;
	// lanc receive and transmit
	net lrx, ltx;
	// switches and leds
	net[7:0] sw, led;
	// motor 0 and 1 encoder
	net[2:0] enc0, enc1;
	// brushed motor 0 and 1 drive
	net pwm0, dir0, pwm1, dir1;
	// brushless motor 0 and 1 drive
	net[2:0] high0, high1, low0, low1;
	// brushless motor 0 and 1 commutation 3-phase sense
	net[2:0] sense0, sense1;
	// memory chip
	net[17:0] addr;
	net[7:0] data;
	net ce0_n, ce1_n, oe_n, we_n, ub_n, lb_n;
	// general purpose IO
	net[7:0] gpio;
	// fpga dedicated nets
	net CCLK, DONE, HSWAP_EN, M0, M1, M2, PROG_B, TCK, TDI, TDO, TMS;
	// switches and leds nets
	net[7:0] sw_res, led_res;
	// dac nets
	net sclk, sync, sdata, dac_out;

	// encoder and sensor
	net[2:0] e0, e1; // brushless motor 0 and 1 encoders [a,b,i]
	net[3:1] s0, s1; // brushless motor 0 and 1 commutation sensors [s3,s2,s1]

	// jtag interface nets
	net din, init_b, d0, rom_clk, rom_ce, tdo_rom, prog_sw, tms_ext, tdi_ext,
	tck_ext;

	// motor 0 and 1 FET driver nets
	net[0:1] ahb, bhb, chb, aho, bho, cho, ahs, bhs, chs, alo, blo, clo, rdel,
	uvlo, rfsh, ahi, bhi, chi, ali, bli, cli;
	// phase a and b, high and low gate nets for both motors
	net[0:1] ahg, bhg, chg, alg, blg, clg;
	// high voltage brushless motor drive nets
	net[2:0] mot0, mot1;
	// diode clamps
	net[0:5] clamps;

	// brushed motor nets
	net[0:1] pwm, dir, out1, out2, boot1, boot2;

	// rs232 level converter nets
	net c1+, c1-, c2+, c2-, r1in, r2in, r1out, r2out, t1in, t2in, t1out, t2out, v+,
	v-;
	net rs232_com, rs232_jump;

	// lanc nets
	net lanc_res, lanc_base, lanc_line;

	/*********************************************************************************
	 * Spartan3 FPGA, decoupling capacitors, mode switches, and HSWAP_EN select
	 */

	inst fpga of top_tq144 {
		LIBRARY = "xilinx_devices";
		PARTNUMBER = "122-1717-ND";
		newattr SUPPLIER = "DIGI-KEY";
		newattr COST = "21.95";

		// Signal pins from FPGA design.
		addr = addr;
		ce0_n = ce0_n;
		ce1_n = ce1_n;
		clk = clk;
		data = data;
		din = din;
		dir0 = dir0;
		dir1 = dir1;
		enc0 = enc0;
		enc1 = enc1;
		gpio = gpio;
		high0 = high0;
		high1 = high1;
		init_b = init_b;
		lb_n = lb_n;
		led = led;
		low0 = low0;
		low1 = low1;
		lrx = lrx;
		ltx = ltx;
		oe_n = oe_n;
		pwm0 = pwm0;
		pwm1 = pwm1;
		rst = rst;
		rxd = rxd;
		rxd_a = rxd_a;
		sclk = sclk;
		sdata = sdata;
		sense0 = sense0;
		sense1 = sense1;
		sw = sw;
		sync = sync;
		txd = txd;
		txd_a = txd_a;
		ub_n = ub_n;
		we_n = we_n;

		// Power and dedicated FPGA pins.
		CCLK = CCLK;
		DONE = DONE;
		GND = &lt;gnd&gt;;
		HSWAP_EN = HSWAP_EN;
		M0 = M0;
		M1 = M1;
		M2 = M2;
		PROG_B = PROG_B;
		TCK = TCK;
		TDI = TDI;
		TDO = TDO;
		TMS = TMS;
		VCCAUX = &lt;vccaux&gt;;
		VCCINT = &lt;vccint&gt;;
		VCCO_0 = &lt;vcco&gt;;
		VCCO_1 = &lt;vcco&gt;;
		VCCO_2 = &lt;vcco&gt;;
		VCCO_3 = &lt;vcco&gt;;
		VCCO_4 = &lt;vcco&gt;;
		VCCO_5 = &lt;vcco&gt;;
		VCCO_6 = &lt;vcco&gt;;
		VCCO_7 = &lt;vcco&gt;;
	}

	// small vcco decoupling caps
	inst(1:12) fpga_vcco_small of C0603 {
		VALUE = "0.047u";
		VOLTAGE = "50v";
		COST = "0.12";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1313-1-ND";
		a = vcco;
		b = gnd;
	}

	// small vccaux decoupling caps
	inst(1:8) fpga_vccaux_small of C0603 {
		VALUE = "0.01u";
		VOLTAGE = "50v";
		COST = "0.08";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1311-1-ND";
		a = vccaux;
		b = gnd;
	}

	// small vccint decoupling caps
	inst(1:8) fpga_vccint_small of C0603 {
		this(1:4).VALUE = "0.047u";
		this(5:8).VALUE = "0.01u";
		this(1:4).COST = "0.12";
		this(5:8).COST = "0.08";
		this(1:4).PARTNUMBER = "445-1313-1-ND";
		this(5:8).PARTNUMBER = "445-1311-1-ND";
		VOLTAGE = "50v";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		a = vccint;
		b = gnd;
	}

	// large vcco decoupling caps
	inst(1:3) fpga_vcco_large of CP_1206MP/T {
		VALUE = "10u";
		VOLTAGE = "16v";
		COST = "0.47";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		PARTNUMBER = "478-1655-1-ND";
		pos = vcco;
		neg = gnd;
	}

	// large vccaux decoupling caps
	inst(1:2) fpga_vccaux_large of CP_1206MP/T {
		VALUE = "10u";
		VOLTAGE = "16v";
		COST = "0.47";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		PARTNUMBER = "478-1655-1-ND";
		pos = vccaux;
		neg = gnd;
	}

	// large vccint decoupling caps
	inst(1:2) fpga_vccint_large of CP_1206MP/T {
		VALUE = "10u";
		VOLTAGE = "16v";
		COST = "0.47";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		PARTNUMBER = "478-1655-1-ND";
		pos = vccint;
		neg = gnd;
	}

	/*********************************************************************************
	 * DIP Switches and resistor network
	 */
	inst fpga_switches of dipswitch {
		a = &lt;vcco&gt;;
		b = sw_res;
	}

	inst(7:0) sw_pulldown of R0603 {
		VALUE = "4.7k";
		PARTNUMBER = "P4.7KGCT-ND";
		combine(a) = sw_res;
		b = gnd;
	}

	inst(7:0) sw_lim of R0603 {
		VALUE = "4.7k";
		PARTNUMBER = "P4.7KGCT-ND";
		combine(a) = sw_res;
		combine(b) = sw;
	}

	/*********************************************************************************
	 * LEDS and resistor network
	 */
	inst(7:0) fpga_leds of LD0603 {
		MFGR = "OSRAM";
		SUPPLIER = "DIGI-KEY";
		PARTNUMBER = "475-2506-1-ND";
		COST = "0.15";
		this(0).REFDES = "LD0";
		this(1).REFDES = "LD1";
		this(2).REFDES = "LD2";
		this(3).REFDES = "LD3";
		this(4).REFDES = "LD4";
		this(5).REFDES = "LD5";
		this(6).REFDES = "LD6";
		this(7).REFDES = "LD7";
		combine(a) = led_res;
		c = gnd;
	}

	inst(7:0) led_lim of R0603 {
		VALUE = "390R";
		PARTNUMBER = "P390GCT-ND";
		combine(a) = led_res;
		combine(b) = led;
	}

	/*********************************************************************************
	 * Memory and decoupling capacitors
	 */
	inst mem0 of RAM256KX16 {
		addr = addr;
		data[7:0] = data;
		data[8:15] = data;
		ce_n = ce0_n;
		oe_n = oe_n;
		we_n = we_n;
		ub_n = ub_n;
		lb_n = lb_n;
		vdd = &lt;vcco&gt;;
		gnd = &lt;gnd&gt;;
		nc = open;
	}

	inst mem1 of RAM256KX16 {
	// address lines remapped for memory on both sides of board
		addr[17] = addr[0];
		addr[16] = addr[1];
		addr[15] = addr[2];
		addr[14] = addr[5];
		addr[13] = addr[6];
		addr[12] = addr[7];
		addr[11] = addr[8];
		addr[10] = addr[9];
		addr[9] = addr[10];
		addr[8] = addr[11];
		addr[7] = addr[12];
		addr[6] = addr[13];
		addr[5] = addr[14];
		addr[4] = addr[4];
		addr[3] = addr[3];
		addr[2] = addr[15];
		addr[1] = addr[16];
		addr[0] = addr[17];
		data[8:15] = data;
		data[7:0] = data;
		ce_n = ce1_n;
		oe_n = oe_n;
		we_n = we_n;
		ub_n = ub_n;
		lb_n = lb_n;
		vdd = &lt;vcco&gt;;
		gnd = &lt;gnd&gt;;
		nc = open;
	}

	inst(1:8) mem_cap of C0603 {
		VALUE = "0.047u";
		VOLTAGE = "50v";
		COST = "0.12";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1313-1-ND";
		a = vcco;
		b = gnd;
	}

	/*********************************************************************************
	 * FPGA Clock and reset
	 */
	inst clk of OSC_50MHZ {
		oe = gnd;
		gnd = gnd;
		output = clk;
		vcc = vcco;
	}

	inst clk_cap of C0603 {
		VALUE = "0.01u";
		VOLTAGE = "50v";
		COST = "0.08";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1311-1-ND";
		a = vcco;
		b = gnd;
	}

	inst rst_btn of TL1105T {
		a = &lt;reset_res&gt;;
		b = &lt;gnd&gt;;
	}

	inst(1:0) rst_res of R0603 {
		VALUE = "4.7k";
		PARTNUMBER = "P4.7KGCT-ND";
		this(0).a = vcco;
		this(0).b = reset_res;
		this(1).a = reset_res;
		this(1).b = rst;
	}

	/*********************************************************************************
	 * FPGA GPIO and mode select jumpers
	 */
	inst pmod_hdr0 of HDR_1X6 {
		FOOTPRINT = "1X06/90";
		LIBRARY = "pinhead";
		p = gpio[3:0] & gnd & vcco;
	} 
	
	inst pmod_hdr1 of HDR_1X6 {
		FOOTPRINT = "1X06/90";
		LIBRARY = "pinhead";
		p = gpio[7:4] & gnd & vcco;
	}

	// sets the configuration mode of the fpga
	inst mode_sel of HDR_2X3 {
		p[6,4,2] = M0 & M1 & M2;
		p[5,3,1] = &lt;gnd&gt;;
	}

	// enable/disable internal pullup resistors during fpga configuration
	inst hswap_sel of HDR_1X3 {
		p = gnd & HSWAP_EN & vcco;
	}

	/*********************************************************************************
	 * FLASH ROM
	 */

	inst flash of rom {
		d0 = d0;
		clk = rom_clk;
		tdi = TDO;
		tms = TMS;
		tck = TCK;
		cf_n = PROG_B;
		oe = init_b;
		ce_n = rom_ce;
		gnd = gnd;
		ceo_n = open;
		tdo = tdo_rom;
		vccint = vcco;
		vcco = vcco;
		vccj = vcco;
		nc = open;
	} inst(1:3) flash_cap of C0603 {
		VALUE = "0.047u";
		VOLTAGE = "50v";
		COST = "0.12";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1313-1-ND";
		a = vcco;
		b = gnd;
	}

	/*********************************************************************************
	 * JTAG programming chain
	 */
	inst(1:3) cfg_pullup of R0603 {
		this(1,2).VALUE = "4.7k";
		this(1,2).PARTNUMBER = "P4.7KGCT-ND";
		this(3).VALUE = "270R";
		this(3).PARTNUMBER = "P270GCT-ND";
		a = vccaux;
		this(1).b = init_b;
		this(2).b = PROG_B;
		this(3).b = DONE;
	} inst done_led of LD0603 {
		MFGR = "OSRAM";
		SUPPLIER = "DIGI-KEY";
		PARTNUMBER = "475-2709-1-ND";
		COST = "0.16";
		a = DONE;
		c = gnd;
	} inst(1:4) jtag_res of R0603 {
		this(1,2).VALUE = "100R";
		this(1,2).PARTNUMBER = "P100GCT-ND";
		this(3).VALUE = "4.7k";
		this(3).PARTNUMBER = "P4.7KGCT-ND";
		this(4).VALUE = "75R";
		this(4).PARTNUMBER = "P75GCT-ND";
		this(1).a = PROG_B;
		this(1).b = prog_sw;
		this(2).a = din;
		this(2).b = d0;
		this(3).a = vcco;
		this(3).b = rom_ce;
		this(4).a = CCLK;
		this(4).b = rom_clk;
	}

	// reprogram switch
	inst prog_fpga of TL1105T {
		a = &lt;prog_sw&gt;;
		b = &lt;gnd&gt;;
	}

	// rom enable jumper
	inst rom_en of HDR_1X3 {
		p = gnd & rom_ce & DONE;
	}

	// JTAG Parallel IV header
	inst jtag_par_iv_hdr of HDR_2X7 {
		FOOTPRINT = "79107-14";
		LIBRARY = "con-headers-jp";
		PARTNUMBER = "WM17469-ND";
		SUPPLIER = "DIGI-KEY";
		COST = "1.76";
		p[2] = vccaux;
		p[4] = TMS;
		p[6] = TCK;
		p[8] = tdo_rom;
		p[10] = TDI;
		p[12,14] = open;
		p[1,3,5,7,9,11,13] = &lt;gnd&gt;;
	}

	// JTAG interface header and current limiting resistors
	inst jtag_hdr of HDR_1X6 {
		FOOTPRINT = "1X06/90";
		LIBRARY = "pinhead";
		p[1] = tms_ext;
		p[2] = tdi_ext;
		p[3] = tdo_rom;
		p[4] = tck_ext;
		p[5] = gnd;
		p[6] = vcco;
	} inst(1:3) jtag_hdr_res of R0603 {
		VALUE = "100R";
		PARTNUMBER = "P100GCT-ND";
		this(1).a = tms_ext;
		this(2).a = tdi_ext;
		this(3).a = tck_ext;
		this(1).b = TMS;
		this(2).b = TDI;
		this(3).b = TCK;
	}

	/*********************************************************************************
	 * 12-bit DAC
	 */

	inst dac of DAC121S101 {
		vout = dac_out;
		gnd = gnd;
		va = vu;
		sdata = sdata;
		sclk = sclk;
		sync = sync;
	}

	// decoupling capacitor
	inst dac_cap of C0603 {
		VALUE = "0.1u";
		VOLTAGE = "50v";
		COST = "0.035";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Yageo";
		PARTNUMBER = "311-1344-1-ND";
		a = vu;
		b = gnd;
	}

	// output connector
	inst dac_hdr of HDR_1X2 {
		FOOTPRINT = "70543-02";
		LIBRARY = "con-molex";
		p = dac_out & gnd;
	}

	/*********************************************************************************
	 * Hex schmitt trigger inverter buffers and encoder header connectors
	 */

	inst enc_buf of 7414_SOIC {
		vcc = vcco;
		gnd = gnd;
		din = e1 & e0[0] & e0[1] & e0[2];
		dout = enc1 & enc0[0] & enc0[1] & enc0[2];
	} inst(0:1) enc_hdrs of HDR_1X5 {
		FOOTPRINT = "70543-05";
		LIBRARY = "con-molex";
		COST = "1.43";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Molex";
		PARTNUMBER = "WM4803-ND";
		this(0).p = e0 & vu & gnd;
		this(1).p = e1 & vu & gnd;
	} inst enc_cap of C0603 {
		VALUE = "0.1u";
		VOLTAGE = "50v";
		COST = "0.035";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Yageo";
		PARTNUMBER = "311-1344-1-ND";
		a = vcco;
		b = gnd;
	}

	/*********************************************************************************
	 * Hex schmitt trigger inverter buffers and brushless motor sensor inputs
	 */

	inst sense_buf of 7414_SOIC {
		vcc = vcco;
		gnd = gnd;
		din = s1 & s0[1] & s0[2] & s0[3];
		dout = sense1 & sense0[0] & sense0[1] & sense0[2];
	} inst(0:1) sense_hdrs of HDR_1X5 {
		FOOTPRINT = "70543-05";
		LIBRARY = "con-molex";
		COST = "1.43";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Molex";
		PARTNUMBER = "WM4803-ND";
		this(0).p = s0 & vu & gnd;
		this(1).p = s1 & vu & gnd;
	}

	// pullups on all brushless motor sensor lines
	inst(5:0) sense_pullup of R0603 {
		VALUE = "1k";
		PARTNUMBER = "P1.0KGCT-ND";
		a = vu;
		combine(this(5,4,3).b) = s1;
		combine(this(2,1,0).b) = s0;
	} inst sense_cap of C0603 {
		VALUE = "0.1u";
		VOLTAGE = "50v";
		COST = "0.035";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Yageo";
		PARTNUMBER = "311-1344-1-ND";
		a = vcco;
		b = gnd;
	}

	/*********************************************************************************
	 * Brushless motor 0 and 1 drive
	 */
	inst(0:1) fet_drivers of HIP4086 {
		combine(this(0:1).bhb) = bhb;
		combine(this(0:1).bhi) = bhi;
		combine(this(0:1).bli) = bli;
		combine(this(0:1).ali) = ali;
		combine(this(0:1).ahi) = ahi;
		vss = gnd;
		combine(this(0:1).rdel) = rdel;
		combine(this(0:1).uvlo) = uvlo;
		combine(this(0:1).rfsh) = rfsh;
		dis = gnd;
		combine(this(0:1).cli) = cli;
		combine(this(0:1).chi) = chi;
		combine(this(0:1).chb) = chb;
		combine(this(0:1).cho) = cho;
		combine(this(0:1).chs) = chs;
		combine(this(0:1).ahb) = ahb;
		combine(this(0:1).aho) = aho;
		combine(this(0:1).ahs) = ahs;
		combine(this(0:1).clo) = clo;
		vdd = vdd;
		combine(this(0:1).alo) = alo;
		combine(this(0:1).blo) = blo;
		combine(this(0:1).bhs) = bhs;
		combine(this(0:1).bho) = bho;
	}

	// re-map vectors from fpga
	ahi = high0[2] & high1[2]; bhi = high0[1] & high1[1];
	chi = high0[0] & high1[0]; ali = low0[2] & low1[2]; bli = low0[1] & low1[1];
	cli = low0[0] & low1[0];

	// power supply decoupling caps
	inst(1:4) fet_driver_cap of CP_1206MP/T {
		this(1,2).VALUE = "4.7u";
		this(1,2).VOLTAGE = "20v";
		this(1,2).COST = "0.38";
		this(1,2).PARTNUMBER = "478-1668-1-ND";
		this(3,4).VALUE = "1u";
		this(3,4).VOLTAGE = "25v";
		this(3,4).COST = "0.38";
		this(3,4).PARTNUMBER = "478-3857-1-ND";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		pos = vdd;
		neg = gnd;
	}

	// configuration resistors
	inst(1:4) config_res of R0603 {
		this(1,3).VALUE = "22K";
		this(1,3).PARTNUMBER = "P22KGCT-ND";
		this(1,3).a = vdd;
		combine(this(1,3).b) = rdel;
		this(2,4).VALUE = "47K";
		this(2,4).PARTNUMBER = "P47KGCT-ND";
		combine(this(2,4).a) = uvlo;
		this(2,4).b = gnd;
	} inst(1:2) rfsh_cap of C0603 {
		VALUE = "470p";
		VOLTAGE = "50v";
		COST = "0.10";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1307-1-ND";
		a = gnd;
		combine(b) = rfsh;
	}

	// bootstrap capacitors
	inst(1:6) bldc_boot_cap of C0603 {
		VALUE = "0.22u";
		VOLTAGE = "50v";
		COST = "0.31";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Murata";
		PARTNUMBER = "490-5402-1-ND";
		combine(this(1,4).a) = ahb;
		combine(this(2,5).a) = bhb;
		combine(this(3,6).a) = chb;
		combine(this(1,4).b) = ahs;
		combine(this(2,5).b) = bhs;
		combine(this(3,6).b) = chs;
	}

	// bootstrap diodes
	inst(1:6) bldc_boot_diode of DO214AC {
		COST = "0.403";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Vishay";
		PARTNUMBER = "US1D-E3/61TGICT-ND";
		a = vdd;
		combine(this(1,4).c) = ahb;
		combine(this(2,5).c) = bhb;
		combine(this(3,6).c) = chb;
	}

	// clamp diodes to prevent negative transients on the floating sense lines
	inst(1:12) bldc_clamp of DO214AC {
		COST = "0.403";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Vishay";
		PARTNUMBER = "US1D-E3/61TGICT-ND";
		this(1:6).a = gnd;
		combine(this(1:6).c) = clamps;
		combine(this(7:12).a) = clamps;
		combine(this(7:12).c) = ahs & bhs & chs;
	}

	// phase sense resistors
	inst(1:6) sense_res of R0603 {
		VALUE = "1R";
		PARTNUMBER = "P1.0GCT-ND";
		combine(this(1,4).a) = ahs;
		combine(this(1,4).b) = mot0[2] & mot1[2];
		combine(this(2,5).a) = bhs;
		combine(this(2,5).b) = mot0[1] & mot1[1];
		combine(this(3,6).a) = chs;
		combine(this(3,6).b) = mot0[0] & mot1[0];
	}

	// gate resistors to dampen any ringing
	inst(1:12) gate_res of R0603 {
		VALUE = "10R";
		PARTNUMBER = "P10GCT-ND";
		combine(this(1,7).a) = aho;
		combine(this(1,7).b) = ahg;
		combine(this(2,8).a) = bho;
		combine(this(2,8).b) = bhg;
		combine(this(3,9).a) = cho;
		combine(this(3,9).b) = chg;
		combine(this(4,10).a) = alo;
		combine(this(4,10).b) = alg;
		combine(this(5,11).a) = blo;
		combine(this(5,11).b) = blg;
		combine(this(6,12).a) = clo;
		combine(this(6,12).b) = clg;
	}

	// 6 FETS for this brushless motor
	inst(1:12) drive_fet of TO252 {
		MFGR = "Fairchild";
		PARTNUMBER = "FDD3682CT-ND";
		SUPPLIER = "DIGI-KEY";
		COST = "1.56";

		// high-side drivers
		combine(this(1,7).g) = ahg;
		combine(this(2,8).g) = bhg;
		combine(this(3,9).g) = chg;

		// low-side drivers
		combine(this(4,10).g) = alg;
		combine(this(5,11).g) = blg;
		combine(this(6,12).g) = clg;

		// power supply to drivers
		combine(this(1,2,3,7,8,9).d) = &lt;vmot&gt;;
		combine(this(4,5,6,10,11,12).s) = &lt;gnd&gt;;

		// mot0 outputs
		combine(this(1,2,3).s) = mot0;
		combine(this(4,5,6).d) = mot0;

		// mot1 outputs
		combine(this(7,8,9).s) = mot1;
		combine(this(10,11,12).d) = mot1;
	}

	// gate-source resistors make sure lower stages are off on powerup
	inst(1:6) gate_source_res of R0603 {
		VALUE = "4.7k";
		PARTNUMBER = "P4.7KGCT-ND";
		combine(this(1,4).a) = alg;
		combine(this(2,5).a) = blg;
		combine(this(3,6).a) = clg;
		b = gnd;
	}

	// output connector
	inst(0:1) bldc_out of HDR_1X3 {
		FOOTPRINT = "22-23-2031";
		LIBRARY = "con-molex";
		this(0).p = mot0;
		this(1).p = mot1;
	}

	/*********************************************************************************
	 * Brushed motor 0 and 1 drive
	 */
	inst(0:1) h_bridges of LMD18200T {
		combine(this(0:1).pwm) = pwm;
		combine(this(0:1).dir) = dir;
		combine(this(0:1).out1) = out1;
		combine(this(0:1).out2) = out2;
		combine(this(0:1).boot1) = boot1;
		combine(this(0:1).boot2) = boot2;
		combine(this(0:1).sense) = open;
		combine(this(0:1).thermal) = open;
		brake = gnd;
		vss = vmot;
		gnd = gnd;
	}

	// remap vectors
	pwm = pwm0 & pwm1; dir = dir0 & dir1;

	// bootstrap capactitors
	inst(1:4) bridge_boot of C0603 {
		VALUE = "0.01u";
		VOLTAGE = "50v";
		COST = "0.08";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1311-1-ND";
		combine(this(1,3).a) = boot1;
		combine(this(1,3).b) = out1;
		combine(this(2,4).a) = boot2;
		combine(this(2,4).b) = out2;
	}

	// output connectors
	inst(0:1) brushed_out of HDR_1X2 {
		FOOTPRINT = "22-23-2021";
		LIBRARY = "con-molex";
		this(0).p = out1[0] & out2[0];
		this(1).p = out1[1] & out2[1];
	}

	// motor power
	inst motor_power of HDR_1X2 {
		FOOTPRINT = "22-23-2021";
		LIBRARY = "con-molex";
		p = vmot & gnd;
	}

	// motor power caps
	inst(1:6) motor_power_caps of CSV-E/F {
		VALUE = "47u";
		VOLTAGE = "63v";
		COST = "0.82";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Panasonic";
		PARTNUMBER = "PCE3946CT-ND";
		pos = vmot;
		neg = gnd;
	}

	// pull down resistors on all bridge inputs so they remain low during fpga configuration
	inst(1:4) pulldowns of R0603 {
		VALUE = "4.7K";
		PARTNUMBER = "P4.7KGCT-ND";
		combine(this(1:4).a) = pwm & dir;
		b = gnd;
	}

	/*********************************************************************************
	 * RS232 Serial port
	 */
	inst level_conv of ST3232C {
		c1+ = c1+;
		v+ = v+;
		c1- = c1-;
		c2+ = c2+;
		c2- = c2-;
		v- = v-;
		t2out = t2out;
		r2in = r2in;
		r2out = r2out;
		t2in = t2in;
		t1in = t1in;
		r1out = r1out;
		r1in = r1in;
		t1out = t1out;
		gnd = gnd;
		vcc = vcco;
	} 
	t1in = txd; t2in = txd_a; 
	
	inst(1:2) rxd_res of R0603 {
		VALUE = "100R";
		PARTNUMBER = "P100GCT-ND";
		this(1).a = rxd;
		this(1).b = r1out;
		this(2).a = rxd_a;
		this(2).b = r2out;
	} 
	
	inst(1:5) conv_cap of C0603 {
		VALUE = "0.1u";
		VOLTAGE = "50v";
		COST = "0.035";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Yageo";
		PARTNUMBER = "311-1344-1-ND";
		this(1).a = c1+;
		this(1).b = c1-;
		this(2).a = c2+;
		this(2).b = c2-;
		this(3).a = vcco;
		this(3).b = v+;
		this(4).a = v-;
		this(4).b = gnd;
		this(5).a = vcco;
		this(5).b = gnd;
	} 
	
	inst rs232_port of SUBD9F {
		p1 = rs232_com;
		p2 = t1out;
		p3 = r1in;
		p4 = rs232_com;
		p5 = gnd;
		p6 = rs232_com;
		p7 = rs232_jump;
		p8 = rs232_jump;
		p9 = open;
		g1 = gnd;
		g2 = gnd;
	} 
	
	inst rs232_aux_port of HDR_1X3 {
		p = t2out & r2in & gnd;
	}

	/*********************************************************************************
	 * LANC interface
	 */

	inst lanc_bjt of BSR14 {
		e = gnd;
		c = lanc_res;
		b = lanc_base;
	}

	// biasing and current limiting resistors
	inst(1:4) lanc_res of R0603 {
		this(1).VALUE = "220R";
		this(1).PARTNUMBER = "P220GCT-ND";
		this(2,3).VALUE = "1k";
		this(2,3).PARTNUMBER = "P1.0KGCT-ND";
		this(4).VALUE = "100R";
		this(4).PARTNUMBER = "P100GCT-ND";
		this(1).a = lrx;
		this(1).b = lanc_res;
		this(2).a = ltx;
		this(2).b = lanc_base;
		this(3).a = vu;
		this(3).b = lanc_res;
		this(4).a = lanc_res;
		this(4).b = lanc_line;
	}

	// LANC connector
	inst lanc of HDR_1X2 {
		FOOTPRINT = "70543-02";
		LIBRARY = "con-molex";
		p = lanc_line & gnd;
	}

	/*********************************************************************************
	 * Power Supply
	 */
	inst a12vdc_in of DC_JACK {
		tip = vdd;
		sleeve = gnd;
		switch = gnd;
	} 
	
	inst(1:2) a12v_pcap of CSV-D {
		VALUE = "100u";
		VOLTAGE = "25v";
		COST = "0.63";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Panasonic";
		PARTNUMBER = "PCE3898CT-ND";
		pos = vdd;
		neg = gnd;
	}

	// 5V regulator
	inst a5v_reg of L7805 {
		input = vdd;
		output = vu;
		ground = gnd;
	} 
	
	inst(1:2) a5v_pcap of CSV-D {
		VALUE = "100u";
		VOLTAGE = "25v";
		COST = "0.63";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Panasonic";
		PARTNUMBER = "PCE3898CT-ND";
		pos = vu;
		neg = gnd;
	} 
	
	inst(1:2) a5v_reg_cap of C0603 {
		this(1).VALUE = "0.33u";
		this(1).VOLTAGE = "50v";
		this(1).COST = "0.16";
		this(1).SUPPLIER = "DIGI-KEY";
		this(1).MFGR = "TDK";
		this(1).PARTNUMBER = "445-5093-1-ND";
		this(2).VALUE = "0.1u";
		this(2).VOLTAGE = "50v";
		this(2).COST = "0.035";
		this(2).SUPPLIER = "DIGI-KEY";
		this(2).MFGR = "Yageo";
		this(2).PARTNUMBER = "311-1344-1-ND";
		this(1).a = vdd;
		this(2).a = vu;
		b = gnd;
	} 
	
	inst a5v_led of LD0603 {
		MFGR = "OSRAM";
		SUPPLIER = "DIGI-KEY";
		PARTNUMBER = "475-2709-1-ND";
		COST = "0.16";
		a = 5v_pwr;
		c = gnd;
	} 
	
	inst a5v_led_res of R0603 {
		VALUE = "1k";
		PARTNUMBER = "P1.0KGCT-ND";
		a = vu;
		b = 5v_pwr;
	}

	// 3.3V Regulator
	inst a3v3_reg of LM1086CS {
		input = vu;
		output = vcco;
		tab = vcco;
		adj/gnd = 3v3_sense;
	} 
	
	inst(1:4) a3v3_cap of CP_1206MP/T {
		this(1).VALUE = "22u";
		this(1).VOLTAGE = "10v";
		this(1).COST = "0.49";
		this(1).PARTNUMBER = "478-5798-1-ND";
		this(2,3,4).VALUE = "10u";
		this(2,3,4).VOLTAGE = "16v";
		this(2,3,4).COST = "0.47";
		this(2,3,4).PARTNUMBER = "478-1655-1-ND";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		this(1,2).pos = vu;
		this(3).pos = 3v3_sense;
		this(4).pos = vcco;
		neg = gnd;
	} 
	
	inst(1:2) a3v3_pcap of CSV-D {
		VALUE = "100u";
		VOLTAGE = "25v";
		COST = "0.63";
		SUPPLIER = "DIGI-KEY";
		MFGR = "Panasonic";
		PARTNUMBER = "PCE3898CT-ND";
		pos = vcco;
		neg = gnd;
	} 
	
	inst(1:2) a3v3_res of R0603 {
		this(1).VALUE = "240R";
		this(2).VALUE = "390R";
		this(1).PARTNUMBER = "P240GCT-ND";
		this(2).PARTNUMBER = "P390GCT-ND";
		this(1).a = vcco;
		this(1).b = 3v3_sense;
		this(2).a = 3v3_sense;
		this(2).b = gnd;
	}
	
	inst a3v3_led of LD0603 {
		MFGR = "OSRAM";
		SUPPLIER = "DIGI-KEY";
		PARTNUMBER = "475-2709-1-ND";
		COST = "0.16";
		a = 3v3_pwr;
		c = gnd;
	} inst a3v3_led_res of R0603 {
		VALUE = "470R";
		PARTNUMBER = "P470GCT-ND";
		a = vcco;
		b = 3v3_pwr;
	}

	// 2.5V Regulator
	inst a2v5_reg of LF25CDT {
		input = vcco;
		output = vccaux;
		gnd = gnd;
	} 
	
	inst(1:3) a2v5_cap of CP_1206MP/T {
		this(1).VALUE = "22u";
		this(1).VOLTAGE = "10v";
		this(1).COST = "0.49";
		this(1).PARTNUMBER = "478-5798-1-ND";
		this(2).VALUE = "0.1u";
		this(2).VOLTAGE = "50v";
		this(2).COST = "0.75";
		this(2).PARTNUMBER = "478-1648-1-ND";
		this(3).VALUE = "10u";
		this(3).VOLTAGE = "16v";
		this(3).COST = "0.47";
		this(3).PARTNUMBER = "478-1655-1-ND";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		this(1,2).pos = vcco;
		this(3).pos = vccaux;
		neg = gnd;
	} 
	
	inst a2v5_res of R0603 {
		VALUE = "2.2k";
		PARTNUMBER = "P2.2KGCT-ND";
		a = vccaux;
		b = gnd;
	} 
	
	inst a2v5_led of LD0603 {
		MFGR = "OSRAM";
		SUPPLIER = "DIGI-KEY";
		PARTNUMBER = "475-2709-1-ND";
		COST = "0.16";
		a = 2v5_pwr;
		c = gnd;
	} 
	
	inst a2v5_led_res of R0603 {
		VALUE = "270R";
		PARTNUMBER = "P270GCT-ND";
		a = vccaux;
		b = 2v5_pwr;
	} 
	
	inst a1v2_reg of LD1117 {
		input = vcco;
		output = vccint;
		gnd = gnd;
	} 
	
	inst a1v2_cap of CP_1206MP/T {
		VALUE = "22u";
		VOLTAGE = "10v";
		COST = "0.49";
		PARTNUMBER = "478-5798-1-ND";
		SUPPLIER = "DIGI-KEY";
		MFGR = "AVX";
		pos = vccint;
		neg = gnd;
	} 
	
	inst a1v2_res of R0603 {
		VALUE = "120R";
		PARTNUMBER = "P120GCT-ND";
		a = vccint;
		b = gnd;
	} 
	
	inst a1v2_reg_cap of C0603 {
		VALUE = "0.01u";
		VOLTAGE = "50v";
		COST = "0.08";
		SUPPLIER = "DIGI-KEY";
		MFGR = "TDK";
		PARTNUMBER = "445-1311-1-ND";
		a = vcco;
		b = gnd;
	}

	// some mounting holes
	inst(1:4) mounts of 3mm6_hole {
	}

}
	</pre>

</body>
</html>
