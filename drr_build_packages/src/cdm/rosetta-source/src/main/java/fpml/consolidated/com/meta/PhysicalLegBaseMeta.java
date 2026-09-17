package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PhysicalLegBase;
import fpml.consolidated.com.validation.PhysicalLegBaseTypeFormatValidator;
import fpml.consolidated.com.validation.PhysicalLegBaseValidator;
import fpml.consolidated.com.validation.exists.PhysicalLegBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalLegBase.class)
public class PhysicalLegBaseMeta implements RosettaMetaData<PhysicalLegBase> {

	@Override
	public List<Validator<? super PhysicalLegBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalLegBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalLegBase> validator(ValidatorFactory factory) {
		return factory.<PhysicalLegBase>create(PhysicalLegBaseValidator.class);
	}

	@Override
	public Validator<? super PhysicalLegBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalLegBase>create(PhysicalLegBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalLegBase> validator() {
		return new PhysicalLegBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalLegBase> typeFormatValidator() {
		return new PhysicalLegBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalLegBase, Set<String>> onlyExistsValidator() {
		return new PhysicalLegBaseOnlyExistsValidator();
	}
}
