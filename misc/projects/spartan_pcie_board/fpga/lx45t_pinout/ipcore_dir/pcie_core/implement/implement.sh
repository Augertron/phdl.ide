#!/bin/sh

# Clean up the results directory
rm -rf results
mkdir results

#Synthesize the Verilog Wrapper Files
echo 'Synthesizing example design with XST';
xst -ifn xst.scr
mv xilinx_pcie_1_1_ep_s6.ngc ./results/pcie_core_top.ngc

cd results

echo 'Running ngdbuild'
ngdbuild \
  -verbose \
  -uc ../../example_design/xilinx_pcie_1_lane_ep_xc6slx45t-fgg484-3.ucf \
  pcie_core_top.ngc


echo 'Running map'
map \
  -o mapped.ncd \
  pcie_core_top.ngd \
  mapped.pcf

echo 'Running par'
par \
  -w mapped.ncd \
  routed.ncd \
  mapped.pcf

echo 'Running trce'
trce \
  -u \
  -v 100 \
  routed.ncd \
  mapped.pcf


echo 'Running design through netgen to create gate-level model'
netgen  \
  -sim  \
  -ofmt vhdl \
  -w \
  -tm xilinx_pcie_1_1_ep_s6 \
  routed.ncd

echo 'Running design through bitgen'
bitgen \
  -w routed.ncd \
  -g spi_buswidth:4 -g extmastercclk_en:yes -g extmastercclk_divide:1 routed.bit \
  mapped.pcf

echo 'Generating PROM file for programming'
promgen -w -p mcs -c FF -o sp605_pcie_x1_gen1 -s 8192 -u 0000 routed.bit -spi

