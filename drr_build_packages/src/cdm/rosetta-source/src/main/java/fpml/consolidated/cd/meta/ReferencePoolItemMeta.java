package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ReferencePoolItem;
import fpml.consolidated.cd.validation.ReferencePoolItemTypeFormatValidator;
import fpml.consolidated.cd.validation.ReferencePoolItemValidator;
import fpml.consolidated.cd.validation.exists.ReferencePoolItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferencePoolItem.class)
public class ReferencePoolItemMeta implements RosettaMetaData<ReferencePoolItem> {

	@Override
	public List<Validator<? super ReferencePoolItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferencePoolItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferencePoolItem> validator(ValidatorFactory factory) {
		return factory.<ReferencePoolItem>create(ReferencePoolItemValidator.class);
	}

	@Override
	public Validator<? super ReferencePoolItem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferencePoolItem>create(ReferencePoolItemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePoolItem> validator() {
		return new ReferencePoolItemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePoolItem> typeFormatValidator() {
		return new ReferencePoolItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePoolItem, Set<String>> onlyExistsValidator() {
		return new ReferencePoolItemOnlyExistsValidator();
	}
}
