package drr.regulation.csa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import drr.regulation.csa.rewrite.trade.validation.CSATransactionReportTradeTypeFormatValidator;
import drr.regulation.csa.rewrite.trade.validation.CSATransactionReportTradeValidator;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0013_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0015_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0018_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0022_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0026_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0026_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0027_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0028_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0029_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0030_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0031_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0032_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0033_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0034_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0035_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0036_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0040_01a;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0040_01b;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0041_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0042_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0043_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0044_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0045_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0046_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0047_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0048_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0049_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0053_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0054_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0055_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0056_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0057_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0058_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0068_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0069_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0070_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0071_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0076_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0095_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0098_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0099_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0100_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0111_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0112_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0113_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0114_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0115_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0116_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0120_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0135_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0136_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0137_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0141_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0142_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0143_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0144_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0145_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportCSA_VR_0147_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0002_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0003_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0016_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0017_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0017_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0019_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0019_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0023_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0026_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0027_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0033_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0033_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0034_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0034_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0040_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0040_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0041_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0041_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0042_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0042_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0045_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0053_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0053_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0054_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0054_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0055_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0055_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0069_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0069_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0070_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0070_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0071_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0071_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0100_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0136_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0137_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0142_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0143_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0144_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_0147_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_03;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_04;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_05;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_07;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_08;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_10;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_11;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_12;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_13;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_14;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_18;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_19;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_20;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportDTCC_CSA_VR_DTCC_23;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0004_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0005_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0006_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0007_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0017_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0019_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0025_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0037_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0038_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0039_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0050_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0051_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0052_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0065_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0066_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0067_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0073_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0074_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0075_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0077_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0078_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0097_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0110_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0118_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0119_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0121_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0122_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0124_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0125_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0126_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0127_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0128_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0129_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0130_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0133_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0138_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0139_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0140_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0146_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeCSA_VR_0148_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0004_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0005_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0006_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0007_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0008_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0009_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0020_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0024_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0025_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0037_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0038_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0050_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0051_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0065_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0075_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0076_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0125_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0126_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0127_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0129_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0138_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0139_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_0140_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_01;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_02;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_06;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_09;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_15;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_16;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_17;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_21;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_22;
import drr.regulation.csa.rewrite.trade.validation.datarule.CSATransactionReportTradeDTCC_CSA_VR_DTCC_24;
import drr.regulation.csa.rewrite.trade.validation.exists.CSATransactionReportTradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSATransactionReportTrade.class)
public class CSATransactionReportTradeMeta implements RosettaMetaData<CSATransactionReportTrade> {

	@Override
	public List<Validator<? super CSATransactionReportTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0002_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0003_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0095_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0013_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0076_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0015_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0016_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0017_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0017_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0018_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0019_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0019_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0022_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0023_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0026_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0026_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0026_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0027_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0027_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0028_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0029_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0030_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0031_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0032_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0033_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0033_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0033_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0034_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0034_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0034_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0035_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0036_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0040_01a.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0040_01b.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0040_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0040_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0041_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0041_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0041_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0042_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0042_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0042_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0043_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0044_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0045_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0045_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0046_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0047_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0048_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0049_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0053_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0053_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0053_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0054_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0054_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0054_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0055_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0055_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0055_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0056_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0057_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0058_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0068_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0069_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0069_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0069_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0070_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0070_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0070_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0071_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0071_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0071_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0098_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0099_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0100_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0100_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0111_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0112_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0113_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0114_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0115_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0116_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0135_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0136_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0136_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0137_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0137_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0141_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0142_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0142_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0143_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_02.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0143_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0144_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0144_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0145_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0147_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_0147_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportCSA_VR_0120_01.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_03.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_04.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_05.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_07.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_08.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_10.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_11.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_12.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_13.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_14.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_18.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_19.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_20.class),
			factory.<CSATransactionReport>create(CSATransactionReportDTCC_CSA_VR_DTCC_23.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0009_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0017_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0019_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0020_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0024_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0025_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0025_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0037_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0037_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0038_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0038_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0039_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0050_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0050_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0051_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0051_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0052_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0065_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0065_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0066_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0067_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0073_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0074_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0075_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0075_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0076_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0077_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0078_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0097_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0110_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0118_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0119_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0121_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0124_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0125_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0125_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0126_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0126_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0127_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0127_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0128_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0129_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0129_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0130_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0133_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0138_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0138_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0139_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0139_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0140_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0140_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0146_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0148_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_02.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_06.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_09.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_15.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_16.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_17.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_21.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_22.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0122_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0004_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0004_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0005_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0005_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0006_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0006_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeCSA_VR_0007_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0007_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_0008_01.class),
			factory.<CSATransactionReportTrade>create(CSATransactionReportTradeDTCC_CSA_VR_DTCC_24.class)
		);
	}
	
	@Override
	public List<Function<? super CSATransactionReportTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSATransactionReportTrade> validator(ValidatorFactory factory) {
		return factory.<CSATransactionReportTrade>create(CSATransactionReportTradeValidator.class);
	}

	@Override
	public Validator<? super CSATransactionReportTrade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSATransactionReportTrade>create(CSATransactionReportTradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSATransactionReportTrade> validator() {
		return new CSATransactionReportTradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSATransactionReportTrade> typeFormatValidator() {
		return new CSATransactionReportTradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSATransactionReportTrade, Set<String>> onlyExistsValidator() {
		return new CSATransactionReportTradeOnlyExistsValidator();
	}
}
