package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FertilizerCommodityUreaAndAmmoniumNitrate2;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityUreaAndAmmoniumNitrate2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FertilizerCommodityUreaAndAmmoniumNitrate2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FertilizerCommodityUreaAndAmmoniumNitrate2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommodityUreaAndAmmoniumNitrate2.class)
public class FertilizerCommodityUreaAndAmmoniumNitrate2Meta implements RosettaMetaData<FertilizerCommodityUreaAndAmmoniumNitrate2> {

	@Override
	public List<Validator<? super FertilizerCommodityUreaAndAmmoniumNitrate2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommodityUreaAndAmmoniumNitrate2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommodityUreaAndAmmoniumNitrate2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityUreaAndAmmoniumNitrate2>create(FertilizerCommodityUreaAndAmmoniumNitrate2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommodityUreaAndAmmoniumNitrate2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommodityUreaAndAmmoniumNitrate2>create(FertilizerCommodityUreaAndAmmoniumNitrate2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityUreaAndAmmoniumNitrate2> validator() {
		return new FertilizerCommodityUreaAndAmmoniumNitrate2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommodityUreaAndAmmoniumNitrate2> typeFormatValidator() {
		return new FertilizerCommodityUreaAndAmmoniumNitrate2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommodityUreaAndAmmoniumNitrate2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommodityUreaAndAmmoniumNitrate2OnlyExistsValidator();
	}
}
