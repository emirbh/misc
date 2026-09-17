package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityTrigger;
import fpml.consolidated.com.validation.CommodityTriggerTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityTriggerValidator;
import fpml.consolidated.com.validation.datarule.CommodityTriggerChoice;
import fpml.consolidated.com.validation.exists.CommodityTriggerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityTrigger.class)
public class CommodityTriggerMeta implements RosettaMetaData<CommodityTrigger> {

	@Override
	public List<Validator<? super CommodityTrigger>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityTrigger>create(CommodityTriggerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityTrigger, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityTrigger> validator(ValidatorFactory factory) {
		return factory.<CommodityTrigger>create(CommodityTriggerValidator.class);
	}

	@Override
	public Validator<? super CommodityTrigger> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityTrigger>create(CommodityTriggerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityTrigger> validator() {
		return new CommodityTriggerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityTrigger> typeFormatValidator() {
		return new CommodityTriggerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityTrigger, Set<String>> onlyExistsValidator() {
		return new CommodityTriggerOnlyExistsValidator();
	}
}
