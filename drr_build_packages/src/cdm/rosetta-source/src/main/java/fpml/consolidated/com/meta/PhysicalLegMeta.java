package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PhysicalLeg;
import fpml.consolidated.com.validation.PhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.PhysicalLegValidator;
import fpml.consolidated.com.validation.exists.PhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalLeg.class)
public class PhysicalLegMeta implements RosettaMetaData<PhysicalLeg> {

	@Override
	public List<Validator<? super PhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<PhysicalLeg>create(PhysicalLegValidator.class);
	}

	@Override
	public Validator<? super PhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalLeg>create(PhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalLeg> validator() {
		return new PhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalLeg> typeFormatValidator() {
		return new PhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalLeg, Set<String>> onlyExistsValidator() {
		return new PhysicalLegOnlyExistsValidator();
	}
}
