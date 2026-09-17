package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.validation.GasPhysicalLegTypeFormatValidator;
import fpml.consolidated.com.validation.GasPhysicalLegValidator;
import fpml.consolidated.com.validation.exists.GasPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GasPhysicalLeg.class)
public class GasPhysicalLegMeta implements RosettaMetaData<GasPhysicalLeg> {

	@Override
	public List<Validator<? super GasPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GasPhysicalLeg> validator(ValidatorFactory factory) {
		return factory.<GasPhysicalLeg>create(GasPhysicalLegValidator.class);
	}

	@Override
	public Validator<? super GasPhysicalLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GasPhysicalLeg>create(GasPhysicalLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GasPhysicalLeg> validator() {
		return new GasPhysicalLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GasPhysicalLeg> typeFormatValidator() {
		return new GasPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new GasPhysicalLegOnlyExistsValidator();
	}
}
