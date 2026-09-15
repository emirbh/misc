package drr.regulation.fca.ukemir.refit.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.validation.FCAUKEMIRMarginReportTypeFormatValidator;
import drr.regulation.fca.ukemir.refit.margin.validation.FCAUKEMIRMarginReportValidator;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3001_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3001_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3001_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3001_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3002_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3002_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3002_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3003_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3003_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3003_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3004_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3004_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3004_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3004_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3005_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3005_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_05;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_06;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3006_07;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3007_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3007_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3007_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3007_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3008_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3008_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3009_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3009_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3010_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3010_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3011_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3012_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3012_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3013_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3013_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3013_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3014_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3014_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3015_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3015_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3015_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3016_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3016_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3016_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3017_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3017_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3018_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3019_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3019_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3020_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3020_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3021_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3021_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3021_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3022_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3022_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3023_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3023_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3023_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3024_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3024_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3024_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3025_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3025_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3026_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3027_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3027_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3028_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3029_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3029_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3029_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3029_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3029_05;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3030_01;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3030_02;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3030_03;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3030_04;
import drr.regulation.fca.ukemir.refit.margin.validation.datarule.FCAUKEMIRMarginReportUKEMIR_VR_3030_05;
import drr.regulation.fca.ukemir.refit.margin.validation.exists.FCAUKEMIRMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAUKEMIRMarginReport.class)
public class FCAUKEMIRMarginReportMeta implements RosettaMetaData<FCAUKEMIRMarginReport> {

	@Override
	public List<Validator<? super FCAUKEMIRMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3001_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3001_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3001_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3001_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3002_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3002_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3002_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3003_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3003_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3003_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3004_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3004_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3004_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3004_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3005_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3005_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_05.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_06.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3006_07.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3007_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3007_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3007_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3007_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3008_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3008_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3009_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3009_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3010_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3010_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3011_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3012_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3012_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3013_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3013_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3013_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3014_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3014_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3015_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3015_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3015_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3016_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3016_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3016_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3017_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3017_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3018_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3019_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3019_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3020_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3020_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3021_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3021_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3021_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3022_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3022_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3023_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3023_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3023_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3024_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3024_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3024_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3025_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3025_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3026_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3027_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3027_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3028_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3029_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3029_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3029_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3029_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3029_05.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3030_01.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3030_02.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3030_03.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3030_04.class),
			factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportUKEMIR_VR_3030_05.class)
		);
	}
	
	@Override
	public List<Function<? super FCAUKEMIRMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAUKEMIRMarginReport> validator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportValidator.class);
	}

	@Override
	public Validator<? super FCAUKEMIRMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRMarginReport>create(FCAUKEMIRMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRMarginReport> validator() {
		return new FCAUKEMIRMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRMarginReport> typeFormatValidator() {
		return new FCAUKEMIRMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAUKEMIRMarginReport, Set<String>> onlyExistsValidator() {
		return new FCAUKEMIRMarginReportOnlyExistsValidator();
	}
}
