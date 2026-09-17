package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxValuationDateOffset;
import fpml.consolidated.fx.validation.FxValuationDateOffsetTypeFormatValidator;
import fpml.consolidated.fx.validation.FxValuationDateOffsetValidator;
import fpml.consolidated.fx.validation.datarule.FxValuationDateOffsetChoice;
import fpml.consolidated.fx.validation.exists.FxValuationDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxValuationDateOffset.class)
public class FxValuationDateOffsetMeta implements RosettaMetaData<FxValuationDateOffset> {

	@Override
	public List<Validator<? super FxValuationDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxValuationDateOffset>create(FxValuationDateOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxValuationDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxValuationDateOffset> validator(ValidatorFactory factory) {
		return factory.<FxValuationDateOffset>create(FxValuationDateOffsetValidator.class);
	}

	@Override
	public Validator<? super FxValuationDateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxValuationDateOffset>create(FxValuationDateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxValuationDateOffset> validator() {
		return new FxValuationDateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxValuationDateOffset> typeFormatValidator() {
		return new FxValuationDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxValuationDateOffset, Set<String>> onlyExistsValidator() {
		return new FxValuationDateOffsetOnlyExistsValidator();
	}
}
