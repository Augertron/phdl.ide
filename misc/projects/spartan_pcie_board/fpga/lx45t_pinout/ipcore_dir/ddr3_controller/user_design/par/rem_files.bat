::****************************************************************************
:: (c) Copyright 2009 Xilinx, Inc. All rights reserved.
::
:: This file contains confidential and proprietary information
:: of Xilinx, Inc. and is protected under U.S. and
:: international copyright and other intellectual property
:: laws.
::
:: DISCLAIMER
:: This disclaimer is not a license and does not grant any
:: rights to the materials distributed herewith. Except as
:: otherwise provided in a valid license issued to you by
:: Xilinx, and to the maximum extent permitted by applicable
:: law: (1) THESE MATERIALS ARE MADE AVAILABLE "AS IS" AND
:: WITH ALL FAULTS, AND XILINX HEREBY DISCLAIMS ALL WARRANTIES
:: AND CONDITIONS, EXPRESS, IMPLIED, OR STATUTORY, INCLUDING
:: BUT NOT LIMITED TO WARRANTIES OF MERCHANTABILITY, NON-
:: INFRINGEMENT, OR FITNESS FOR ANY PARTICULAR PURPOSE; and
:: (2) Xilinx shall not be liable (whether in contract or tort,
:: including negligence, or under any other theory of
:: liability) for any loss or damage of any kind or nature
:: related to, arising under or in connection with these
:: materials, including for any direct, or any indirect,
:: special, incidental, or consequential loss or damage
:: (including loss of data, profits, goodwill, or any type of
:: loss or damage suffered as a result of any action brought
:: by a third party) even if such damage or loss was
:: reasonably foreseeable or Xilinx had been advised of the
:: possibility of the same.
::
:: CRITICAL APPLICATIONS
:: Xilinx products are not designed or intended to be fail-
:: safe, or for use in any application requiring fail-safe
:: performance, such as life-support or safety devices or
:: systems, Class III medical devices, nuclear facilities,
:: applications related to the deployment of airbags, or any
:: other applications that could lead to death, personal
:: injury, or severe property or environmental damage
:: (individually and collectively, "Critical
:: Applications"). Customer assumes the sole risk and
:: liability of any use of Xilinx products in Critical
:: Applications, subject only to applicable laws and
:: regulations governing limitations on product liability.
::
:: THIS COPYRIGHT NOTICE AND DISCLAIMER MUST BE RETAINED AS
:: PART OF THIS FILE AT ALL TIMES.
::
::****************************************************************************
::   ____  ____
::  /   /\/   /
:: /___/  \  /    Vendor                : Xilinx
:: \   \   \/     Version               : 3.9
::  \   \         Application           : MIG
::  /   /         Filename              : rem_files.bat
:: /___/   /\     Date Last Modified    : $Date: 2011/06/02 07:16:57 $
:: \   \  /  \    Date Created          : Fri Feb 06 2009
::  \___\/\___\
::
:: Device            : Spartan-6
:: Design Name       : DDR/DDR2/DDR3/LPDDR
:: Purpose           : Batch file to remove files generated ISE
:: Reference         :
:: Revision History  :
::****************************************************************************

@echo off
IF EXIST "../synth/__projnav" rmdir /S /Q "../synth/__projnav" 
IF EXIST "../synth/xst" rmdir /S /Q "../synth/xst" 
IF EXIST "../synth/_ngo" rmdir /S /Q "../synth/_ngo" 
IF EXIST "../synth/xst/work" rmdir /S /Q "../synth/xst/work" 

IF EXIST tmp rmdir /S /Q tmp
IF EXIST _xmsgs rmdir /S /Q _xmsgs
IF EXIST ila_xdb rmdir /S /Q ila_xdb
IF EXIST icon_xdb rmdir /S /Q icon_xdb
IF EXIST xlnx_auto_0_xdb rmdir /S /Q xlnx_auto_0_xdb
IF EXIST vio_xdb rmdir /S /Q vio_xdb

IF EXIST vio_xmdf.tcl del /F /Q vio_xmdf.tcl
IF EXIST vio_readme.txt del /F /Q vio_readme.txt
IF EXIST vio_flist.txt del /F /Q vio_flist.txt
IF EXIST vio.xise del /F /Q vio.xise
IF EXIST vio.xco del /F /Q vio.xco
IF EXIST vio.ngc del /F /Q vio.ngc
IF EXIST vio.ise del /F /Q vio.ise
IF EXIST vio.gise del /F /Q vio.gise
IF EXIST vio.cdc del /F /Q vio.cdc

IF EXIST coregen.cgp del /F /Q coregen.cgp
IF EXIST coregen.cgc del /F /Q coregen.cgc
IF EXIST coregen.log del /F /Q coregen.log
IF EXIST ila.cdc del /F /Q ila.cdc
IF EXIST ila.gise del /F /Q ila.gise
IF EXIST ila.ise del /F /Q ila.ise
IF EXIST ila.ngc del /F /Q ila.ngc
IF EXIST ila.xco del /F /Q ila.xco
IF EXIST ila.xise del /F /Q ila.xise
IF EXIST ila_flist.txt del /F /Q ila_flist.txt
IF EXIST ila_readme.txt del /F /Q ila_readme.txt
IF EXIST ila_xmdf.tcl del /F /Q ila_xmdf.tcl

IF EXIST icon.asy del /F /Q icon.asy
IF EXIST icon.gise del /F /Q icon.gise
IF EXIST icon.ise del /F /Q icon.ise
IF EXIST icon.ncf del /F /Q icon.ncf
IF EXIST icon.ngc del /F /Q icon.ngc
IF EXIST icon.xco del /F /Q icon.xco
IF EXIST icon.xise del /F /Q icon.xise
IF EXIST icon_flist.txt del /F /Q icon_flist.txt
IF EXIST icon_readme.txt del /F /Q icon_readme.txt
IF EXIST icon_xmdf.tcl del /F /Q icon_xmdf.tcl

IF EXIST ise_flow_results.txt del /F /Q ise_flow_results.txt
IF EXIST ddr3_controller_vhdl.prj del /F /Q ddr3_controller_vhdl.prj
IF EXIST mem_interface_top.syr del /F /Q mem_interface_top.syr
IF EXIST ddr3_controller.ngc del /F /Q ddr3_controller.ngc
IF EXIST ddr3_controller.ngr del /F /Q ddr3_controller.ngr
IF EXIST ddr3_controller_xst.xrpt del /F /Q ddr3_controller_xst.xrpt
IF EXIST ddr3_controller.bld del /F /Q ddr3_controller.bld
IF EXIST ddr3_controller.ngd del /F /Q ddr3_controller.ngd
IF EXIST ddr3_controller_ngdbuild.xrpt del /F /Q  ddr3_controller_ngdbuild.xrpt
IF EXIST ddr3_controller_map.map del /F /Q  ddr3_controller_map.map
IF EXIST ddr3_controller_map.mrp del /F /Q  ddr3_controller_map.mrp
IF EXIST ddr3_controller_map.ngm del /F /Q  ddr3_controller_map.ngm
IF EXIST ddr3_controller.pcf del /F /Q  ddr3_controller.pcf
IF EXIST ddr3_controller_map.ncd del /F /Q  ddr3_controller_map.ncd
IF EXIST ddr3_controller_map.xrpt del /F /Q  ddr3_controller_map.xrpt
IF EXIST ddr3_controller_summary.xml del /F /Q  ddr3_controller_summary.xml
IF EXIST ddr3_controller_usage.xml del /F /Q  ddr3_controller_usage.xml
IF EXIST ddr3_controller.ncd del /F /Q  ddr3_controller.ncd
IF EXIST ddr3_controller.par del /F /Q  ddr3_controller.par
IF EXIST ddr3_controller.xpi del /F /Q  ddr3_controller.xpi
IF EXIST ddr3_controller.ptwx del /F /Q  ddr3_controller.ptwx
IF EXIST ddr3_controller.pad del /F /Q  ddr3_controller.pad
IF EXIST ddr3_controller.unroutes del /F /Q  ddr3_controller.unroutes
IF EXIST ddr3_controller_pad.csv del /F /Q  ddr3_controller_pad.csv
IF EXIST ddr3_controller_pad.txt del /F /Q  ddr3_controller_pad.txt
IF EXIST ddr3_controller_par.xrpt del /F /Q  ddr3_controller_par.xrpt
IF EXIST ddr3_controller.twx del /F /Q  ddr3_controller.twx
IF EXIST ddr3_controller.bgn del /F /Q  ddr3_controller.bgn
IF EXIST ddr3_controller.twr del /F /Q  ddr3_controller.twr
IF EXIST ddr3_controller.drc del /F /Q  ddr3_controller.drc
IF EXIST ddr3_controller_bitgen.xwbt del /F /Q  ddr3_controller_bitgen.xwbt
IF EXIST ddr3_controller.bit del /F /Q  ddr3_controller.bit

:: Files and folders generated by create ise
IF EXIST test_xdb rmdir /S /Q test_xdb 
IF EXIST _xmsgs rmdir /S /Q _xmsgs 
IF EXIST test.gise del /F /Q test.gise
IF EXIST test.xise del /F /Q test.xise
IF EXIST test.xise del /F /Q test.xise

:: Files and folders generated by ISE through GUI mode
IF EXIST _ngo rmdir /S /Q _ngo 
IF EXIST xst rmdir /S /Q xst 
IF EXIST ddr3_controller.lso del /F /Q ddr3_controller.lso
IF EXIST ddr3_controller.prj del /F /Q ddr3_controller.prj
IF EXIST ddr3_controller.xst del /F /Q ddr3_controller.xst
IF EXIST ddr3_controller.stx del /F /Q ddr3_controller.stx
IF EXIST ddr3_controller_prev_built.ngd del /F /Q ddr3_controller_prev_built.ngd
IF EXIST test.ntrc_log del /F /Q test.ntrc_log
IF EXIST ddr3_controller_guide.ncd del /F /Q ddr3_controller_guide.ncd
IF EXIST ddr3_controller.cmd_log del /F /Q ddr3_controller.cmd_log
IF EXIST ddr3_controller_summary.html del /F /Q ddr3_controller_summary.html
IF EXIST ddr3_controller.ut del /F /Q ddr3_controller.ut
IF EXIST par_usage_statistics.html del /F /Q par_usage_statistics.html
IF EXIST usage_statistics_webtalk.html del /F /Q usage_statistics_webtalk.html
IF EXIST webtalk.log del /F /Q webtalk.log
IF EXIST device_usage_statistics.html del /F /Q device_usage_statistics.html

@echo on
