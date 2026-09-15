package drr.regulation.fca.ukemir.refit.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.regulation.fca.ukemir.refit.trade.validation.FCAUKEMIRTransactionReportTypeFormatValidator;
import drr.regulation.fca.ukemir.refit.trade.validation.FCAUKEMIRTransactionReportValidator;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1001_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1001_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1001_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1001_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1001_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1002_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1002_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1002_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1002_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1003_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1003_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1003_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1003_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1003_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1004_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1004_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1004_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1004_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1004_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1005_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1006_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1006_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1006_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1007_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1007_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1008_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1008_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1009_08;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1010_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1010_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1011_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1011_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1012_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1012_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1012_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1013_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1013_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1014_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1014_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1015_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1015_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1016_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1017_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1017_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1018_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1018_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1018_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1019_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1019_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1019_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1020_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1020_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_1021_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2001_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2001_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2001_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2001_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2002_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2002_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2002_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2002_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2003_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2003_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2003_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2003_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2003_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2004_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2004_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2004_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2004_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2005_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2005_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2005_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2005_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2006_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2007_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2007_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2008_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2008_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2008_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2008_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2009_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2009_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2010_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2011_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2012_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2013_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2013_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2013_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2013_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2013_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2014_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2014_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2014_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2015_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2015_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2016_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2017_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2017_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2017_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2018_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2019_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2019_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2019_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2019_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2020_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2020_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2021_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2022_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2022_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2022_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2023_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2024_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2024_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2024_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2025_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2025_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2025_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2026_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2027_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2028_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2028_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2028_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2028_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2028_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2029_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2030_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2030_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2031_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2032_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2032_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2032_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2032_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2032_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2033_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2033_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2033_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2033_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2034_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2035_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2036_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2036_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2037_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2038_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2039_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2040_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2040_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2040_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2040_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2041_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2041_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2042_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2042_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2043_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2043_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2044_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2044_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2044_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2044_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2045_08;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2046_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2046_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2046_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2046_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2047_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2048_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2048_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2048_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2049_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2049_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2049_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2050_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2050_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2051_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2051_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2052_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2052_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2053_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2053_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2053_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2053_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2054_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2054_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2054_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2055_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2056_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2056_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2057_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2057_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2059_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2060_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2061_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2061_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2062_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2062_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2063_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2064_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2065_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2065_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2066_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2066_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2068_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2069_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2070_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2070_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2071_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2071_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2072_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2073_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2074_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2075_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2075_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2076_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2077_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2077_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2077_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2077_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2077_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2078_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2078_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2078_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2078_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2078_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2079_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2079_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2079_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2080_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2081_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2082_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2083_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2083_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2084_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2084_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2085_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2085_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2086_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2087_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2088_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2089_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2090_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2091_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2092_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2093_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2093_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2093_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2094_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2094_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2095_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2095_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2096_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2097_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2098_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2099_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2099_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2100_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2100_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2101_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2101_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2102_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2103_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2104_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2105_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2106_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2107_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2108_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2109_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2109_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2109_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2110_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2111_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2111_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2111_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2111_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2112_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2112_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2113_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2113_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2113_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2114_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2114_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2114_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2115_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2115_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2116_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_08;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_09;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2117_10;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_08;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_09;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_10;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_11;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_12;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2118_13;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2119_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2120_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2121_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2122_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2123_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2124_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2125_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2126_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2127_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2128_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2129_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2130_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2131_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2132_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2133_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2134_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2134_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2134_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2134_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2135_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2136_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2136_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2138_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2138_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2138_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2139_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2140_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2140_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2141_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2142_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2142_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2143_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2144_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2144_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2144_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2144_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2145_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2146_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2147_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2148_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2149_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2149_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2150_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2151_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2152_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2152_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2152_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2152_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2152_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_03;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_04;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_05;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_06;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2153_07;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2154_01;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2154_02;
import drr.regulation.fca.ukemir.refit.trade.validation.datarule.FCAUKEMIRTransactionReportUKEMIR_VR_2154_03;
import drr.regulation.fca.ukemir.refit.trade.validation.exists.FCAUKEMIRTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAUKEMIRTransactionReport.class)
public class FCAUKEMIRTransactionReportMeta implements RosettaMetaData<FCAUKEMIRTransactionReport> {

	@Override
	public List<Validator<? super FCAUKEMIRTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1001_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1001_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1001_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1001_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1001_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1002_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1002_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1002_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1002_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1003_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1003_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1003_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1003_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1003_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1004_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1004_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1004_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1004_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1004_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1005_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1006_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1006_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1006_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1007_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1007_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1008_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1008_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1009_08.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1010_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1010_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1011_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1011_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1012_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1012_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1012_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1013_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1013_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1014_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1014_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1015_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1015_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1016_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1017_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1017_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1018_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1018_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1018_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1019_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1019_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1019_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1020_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1020_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_1021_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2001_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2001_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2001_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2001_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2002_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2002_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2002_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2002_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2003_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2003_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2003_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2003_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2003_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2004_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2004_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2004_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2004_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2005_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2005_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2005_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2005_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2006_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2007_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2007_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2008_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2008_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2008_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2008_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2009_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2009_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2010_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2011_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2012_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2013_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2013_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2013_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2013_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2013_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2014_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2014_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2014_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2015_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2015_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2016_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2017_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2017_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2017_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2018_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2019_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2019_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2019_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2019_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2020_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2020_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2021_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2022_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2022_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2022_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2023_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2024_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2024_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2024_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2025_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2025_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2025_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2026_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2027_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2028_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2028_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2028_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2028_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2028_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2029_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2030_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2030_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2031_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2032_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2032_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2032_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2032_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2032_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2033_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2033_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2033_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2033_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2034_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2035_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2036_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2036_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2037_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2038_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2039_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2040_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2040_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2040_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2040_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2041_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2041_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2042_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2042_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2043_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2043_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2044_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2044_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2044_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2044_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2045_08.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2046_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2046_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2046_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2046_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2047_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2048_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2048_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2048_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2049_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2049_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2049_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2050_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2050_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2051_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2051_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2052_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2052_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2053_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2053_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2053_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2053_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2054_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2054_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2054_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2055_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2056_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2056_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2057_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2057_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2059_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2060_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2061_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2061_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2062_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2062_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2063_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2064_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2065_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2065_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2066_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2066_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2068_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2069_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2070_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2070_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2071_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2071_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2072_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2073_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2074_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2075_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2075_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2076_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2077_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2077_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2077_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2077_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2077_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2078_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2078_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2078_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2078_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2078_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2079_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2079_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2079_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2080_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2081_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2082_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2083_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2083_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2084_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2084_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2085_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2085_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2086_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2087_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2088_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2089_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2090_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2091_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2092_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2093_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2093_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2093_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2094_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2094_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2095_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2095_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2096_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2097_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2098_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2099_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2099_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2100_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2100_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2101_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2101_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2102_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2103_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2104_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2105_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2106_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2107_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2108_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2109_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2109_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2109_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2110_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2111_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2111_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2111_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2111_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2112_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2112_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2113_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2113_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2113_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2114_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2114_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2114_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2115_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2115_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2116_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_08.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_09.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2117_10.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_08.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_09.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_10.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_11.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_12.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2118_13.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2119_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2120_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2121_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2122_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2123_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2124_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2125_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2126_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2127_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2128_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2129_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2130_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2131_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2132_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2133_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2134_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2134_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2134_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2134_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2135_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2136_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2136_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2138_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2138_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2138_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2139_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2140_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2140_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2141_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2142_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2142_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2143_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2144_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2144_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2144_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2144_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2145_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2146_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2147_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2148_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2149_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2149_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2150_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2151_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2152_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2152_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2152_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2152_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2152_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_03.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_04.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_05.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_06.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2153_07.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2154_01.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2154_02.class),
			factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportUKEMIR_VR_2154_03.class)
		);
	}
	
	@Override
	public List<Function<? super FCAUKEMIRTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAUKEMIRTransactionReport> validator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportValidator.class);
	}

	@Override
	public Validator<? super FCAUKEMIRTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRTransactionReport>create(FCAUKEMIRTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRTransactionReport> validator() {
		return new FCAUKEMIRTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRTransactionReport> typeFormatValidator() {
		return new FCAUKEMIRTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAUKEMIRTransactionReport, Set<String>> onlyExistsValidator() {
		return new FCAUKEMIRTransactionReportOnlyExistsValidator();
	}
}
