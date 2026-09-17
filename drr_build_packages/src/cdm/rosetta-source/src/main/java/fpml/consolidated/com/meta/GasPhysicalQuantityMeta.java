package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.GasPhysicalQuantity;
import fpml.consolidated.com.validation.GasPhysicalQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.GasPhysicalQuantityValidator;
import fpml.consolidated.com.validation.datarule.GasPhysicalQuantityChoice;
import fpml.consolidated.com.validation.exists.GasPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GasPhysicalQuantity.class)
public class GasPhysicalQuantityMeta implements RosettaMetaData<GasPhysicalQuantity> {

	@Override
	public List<Validator<? super GasPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GasPhysicalQuantity>create(GasPhysicalQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GasPhysicalQuantity> validator(ValidatorFactory factory) {
		return factory.<GasPhysicalQuantity>create(GasPhysicalQuantityValidator.class);
	}

	@Override
	public Validator<? super GasPhysicalQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GasPhysicalQuantity>create(GasPhysicalQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GasPhysicalQuantity> validator() {
		return new GasPhysicalQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GasPhysicalQuantity> typeFormatValidator() {
		return new GasPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new GasPhysicalQuantityOnlyExistsValidator();
	}
}
