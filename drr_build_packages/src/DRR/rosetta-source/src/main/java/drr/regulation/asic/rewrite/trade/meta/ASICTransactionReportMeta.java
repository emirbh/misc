package drr.regulation.asic.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.asic.rewrite.trade.validation.ASICTransactionReportTypeFormatValidator;
import drr.regulation.asic.rewrite.trade.validation.ASICTransactionReportValidator;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0001a_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0001b_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0001c_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0204_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0205_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0206_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0207;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0208_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0209_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0210;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0210a;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0211;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0212;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0213;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0213a;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0214;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_0215;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1001_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1006_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1007_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1007a_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1009_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1010_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1011_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1012_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1013_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1013a_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1014_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1015_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1016_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1018_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1019_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1020_01a;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1020_01b;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1020_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1021_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1023_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1024_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1025_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1026_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1026_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1026_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1027_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1027_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1027_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1028_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1029_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1030_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1030_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1030_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1031_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1031_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1031_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1032_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1033_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1034_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1034_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1034_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1035_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1036_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1037_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1038_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1039_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1040_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1041_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1042_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1042_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1043_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1044_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1045_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1046_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_04;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_05;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1047_06;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1048_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1049_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1050_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1050_04;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1051_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1052_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1053_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1053_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1054_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1055_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1055_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1056_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1057_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1058_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1058a_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1058a_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1058b_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1059_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1059_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1060_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1060_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1060_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1060_04;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1061_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1062_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1063_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1064_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1065_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1065_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1066_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1066_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1067_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1067_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1067_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1068_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1069_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1069_03;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1070_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1070_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1071_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1071_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1072_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1073_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1074_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1075_01_A;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1075_01_B;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1075_02_A;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1075_02_B;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1076_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1077_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1078_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1079_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1080_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1080_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1081_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1082_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1083_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1084_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1084_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1085_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1087_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1088_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1089_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1090_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1091_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1093_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1094_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1094_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1095_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1096_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1097_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1097_02;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1098_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1099_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1100_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1101_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_1102_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_2008_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_2010_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_3010_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportDTCC_ASIC_BR_3011_01;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportPriorUti;
import drr.regulation.asic.rewrite.trade.validation.datarule.ASICTransactionReportUti;
import drr.regulation.asic.rewrite.trade.validation.exists.ASICTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ASICTransactionReport.class)
public class ASICTransactionReportMeta implements RosettaMetaData<ASICTransactionReport> {

	@Override
	public List<Validator<? super ASICTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1001_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1006_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1007_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1007a_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1009_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1010_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1011_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1012_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1013_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1013a_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1014_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1015_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1016_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1018_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1019_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1020_01a.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1020_01b.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1020_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1021_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1023_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1024_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1025_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1026_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1026_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1026_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1027_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1027_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1027_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1028_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1029_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1030_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1030_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1030_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1031_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1031_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1032_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1031_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1033_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1034_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1034_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1034_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1035_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1036_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1037_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1038_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1039_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1040_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1041_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1042_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1042_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1043_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1044_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1045_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1046_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_04.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_05.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1047_06.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1048_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1049_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1050_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1050_04.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1051_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1052_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1053_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1053_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1054_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1055_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1055_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1056_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1057_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1058_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1058a_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1058a_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1058b_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0001a_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0001b_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0001c_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1059_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1059_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1060_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1060_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1060_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1060_04.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1061_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1062_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1063_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1064_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1065_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1065_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1066_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1066_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1067_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1067_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1067_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1068_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1069_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1069_03.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1070_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1070_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1071_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1071_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1072_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1073_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1074_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1075_01_A.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1075_01_B.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1075_02_A.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1075_02_B.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1076_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1077_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1078_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1079_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1080_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1080_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1081_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1082_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1083_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1084_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1084_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1085_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1087_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1088_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1089_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1090_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1091_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1093_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1094_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1094_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1095_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1096_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1097_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1097_02.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1098_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1099_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1100_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1101_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_1102_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_2008_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_2010_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_3010_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_3011_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0204_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0205_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0206_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0207.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0208_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0209_01.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0210.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0210a.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0211.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0212.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0213.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0213a.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0214.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportDTCC_ASIC_BR_0215.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportUti.class),
			factory.<ASICTransactionReport>create(ASICTransactionReportPriorUti.class)
		);
	}
	
	@Override
	public List<Function<? super ASICTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ASICTransactionReport> validator(ValidatorFactory factory) {
		return factory.<ASICTransactionReport>create(ASICTransactionReportValidator.class);
	}

	@Override
	public Validator<? super ASICTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ASICTransactionReport>create(ASICTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ASICTransactionReport> validator() {
		return new ASICTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ASICTransactionReport> typeFormatValidator() {
		return new ASICTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ASICTransactionReport, Set<String>> onlyExistsValidator() {
		return new ASICTransactionReportOnlyExistsValidator();
	}
}
