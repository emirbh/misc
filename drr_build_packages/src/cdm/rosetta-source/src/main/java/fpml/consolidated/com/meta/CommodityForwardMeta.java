package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.validation.CommodityForwardTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityForwardValidator;
import fpml.consolidated.com.validation.datarule.CommodityForwardChoice;
import fpml.consolidated.com.validation.exists.CommodityForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityForward.class)
public class CommodityForwardMeta implements RosettaMetaData<CommodityForward> {

	@Override
	public List<Validator<? super CommodityForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityForward>create(CommodityForwardChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityForward> validator(ValidatorFactory factory) {
		return factory.<CommodityForward>create(CommodityForwardValidator.class);
	}

	@Override
	public Validator<? super CommodityForward> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityForward>create(CommodityForwardTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityForward> validator() {
		return new CommodityForwardValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityForward> typeFormatValidator() {
		return new CommodityForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityForward, Set<String>> onlyExistsValidator() {
		return new CommodityForwardOnlyExistsValidator();
	}
}
