package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityDetails;
import fpml.consolidated.asset.validation.CommodityDetailsTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityDetailsValidator;
import fpml.consolidated.asset.validation.exists.CommodityDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDetails.class)
public class CommodityDetailsMeta implements RosettaMetaData<CommodityDetails> {

	@Override
	public List<Validator<? super CommodityDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDetails> validator(ValidatorFactory factory) {
		return factory.<CommodityDetails>create(CommodityDetailsValidator.class);
	}

	@Override
	public Validator<? super CommodityDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDetails>create(CommodityDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDetails> validator() {
		return new CommodityDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDetails> typeFormatValidator() {
		return new CommodityDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDetails, Set<String>> onlyExistsValidator() {
		return new CommodityDetailsOnlyExistsValidator();
	}
}
