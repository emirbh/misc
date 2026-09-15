package drr.regulation.mas.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.regulation.mas.rewrite.trade.validation.MASTransactionReportTypeFormatValidator;
import drr.regulation.mas.rewrite.trade.validation.MASTransactionReportValidator;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0001_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0001a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0002_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0002a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0005_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0006_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0007_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0010_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0011_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0012_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0015_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0015_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0015_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0015_04;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0015_05;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0016_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0016_04;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0019_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0019_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0020_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0021_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0022_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0025_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0025_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0026_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0027_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0030_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0032_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0036_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0037_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0038_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0040_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0041_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0042_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0048_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0049_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0050_01a;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0050_01b;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0050_01c;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0050_01d;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0050_01e;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0052_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0054_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0058_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0058_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0076_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0076_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0076a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0076a_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0077_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0077_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0077_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0078_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0078_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0078_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0078a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0078a_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0079_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0080_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0081_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0082_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0082_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0082a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0082a_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0082a_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0083_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0084_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0085_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0086_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0087_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0087_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0087a_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0087a_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0087a_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0088_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0089_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0090_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0091_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0092_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0093_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0094_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0094_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0094_02b;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0094_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0095_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0096_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0097_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0098_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0099_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0100_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0101_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0101_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0102_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0102_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0102_03;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0102_04;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0103_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0104_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0105_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0106_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0107_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0108_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0109_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0110_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0110_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0111_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0112_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0113_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0114_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0114_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0115_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0116_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0117_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0118_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0119_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0120_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0121_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0122_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0123_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0124_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0125_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0125_02;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0126_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0127_01_A;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0127_01_B;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0127_02_A;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0127_02_B;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0128_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0129_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0130_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0131_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0133_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0134_01;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0135_01a;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0135_01b;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0135_01c;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportDTCC_MAS_BR_0135_01d;
import drr.regulation.mas.rewrite.trade.validation.datarule.MASTransactionReportUtiRequired;
import drr.regulation.mas.rewrite.trade.validation.exists.MASTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=MASTransactionReport.class)
public class MASTransactionReportMeta implements RosettaMetaData<MASTransactionReport> {

	@Override
	public List<Validator<? super MASTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0001_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0002_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0005_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0006_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0007_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportUtiRequired.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0010_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0011_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0012_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0015_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0015_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0015_05.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0015_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0015_04.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0016_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0016_04.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0019_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0019_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0020_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0021_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0022_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0025_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0025_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0026_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0027_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0030_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0032_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0036_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0037_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0038_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0040_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0041_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0042_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0048_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0049_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0050_01a.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0050_01b.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0050_01c.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0050_01d.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0050_01e.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0052_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0054_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0058_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0058_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0076_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0076_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0077_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0077_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0077_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0078_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0078_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0078_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0079_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0080_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0081_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0082_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0082_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0083_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0084_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0085_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0086_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0087_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0087_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0088_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0089_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0090_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0091_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0092_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0093_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0094_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0094_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0094_02b.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0094_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0095_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0096_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0097_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0098_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0099_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0100_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0101_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0101_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0102_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0102_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0102_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0102_04.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0103_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0104_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0105_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0106_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0107_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0108_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0109_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0110_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0110_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0111_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0112_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0113_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0114_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0114_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0115_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0116_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0117_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0118_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0119_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0120_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0121_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0122_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0123_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0124_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0125_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0125_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0126_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0127_01_A.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0127_01_B.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0127_02_A.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0127_02_B.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0128_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0129_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0130_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0131_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0133_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0134_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0001a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0002a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0076a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0076a_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0078a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0078a_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0082a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0082a_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0082a_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0087a_01.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0087a_02.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0087a_03.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0135_01a.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0135_01b.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0135_01c.class),
			factory.<MASTransactionReport>create(MASTransactionReportDTCC_MAS_BR_0135_01d.class)
		);
	}
	
	@Override
	public List<Function<? super MASTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MASTransactionReport> validator(ValidatorFactory factory) {
		return factory.<MASTransactionReport>create(MASTransactionReportValidator.class);
	}

	@Override
	public Validator<? super MASTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MASTransactionReport>create(MASTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MASTransactionReport> validator() {
		return new MASTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MASTransactionReport> typeFormatValidator() {
		return new MASTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MASTransactionReport, Set<String>> onlyExistsValidator() {
		return new MASTransactionReportOnlyExistsValidator();
	}
}
