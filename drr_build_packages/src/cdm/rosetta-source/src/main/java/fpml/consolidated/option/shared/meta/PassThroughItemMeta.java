package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.PassThroughItem;
import fpml.consolidated.option.shared.validation.PassThroughItemTypeFormatValidator;
import fpml.consolidated.option.shared.validation.PassThroughItemValidator;
import fpml.consolidated.option.shared.validation.exists.PassThroughItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PassThroughItem.class)
public class PassThroughItemMeta implements RosettaMetaData<PassThroughItem> {

	@Override
	public List<Validator<? super PassThroughItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PassThroughItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PassThroughItem> validator(ValidatorFactory factory) {
		return factory.<PassThroughItem>create(PassThroughItemValidator.class);
	}

	@Override
	public Validator<? super PassThroughItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PassThroughItem>create(PassThroughItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PassThroughItem> validator() {
		return new PassThroughItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PassThroughItem> typeFormatValidator() {
		return new PassThroughItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PassThroughItem, Set<String>> onlyExistsValidator() {
		return new PassThroughItemOnlyExistsValidator();
	}
}
