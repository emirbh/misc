package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.Substitution;
import cdm.legaldocumentation.csa.validation.SubstitutionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SubstitutionValidator;
import cdm.legaldocumentation.csa.validation.exists.SubstitutionOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Substitution.class)
public class SubstitutionMeta implements RosettaMetaData<Substitution> {

	@Override
	public List<Validator<? super Substitution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Substitution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Substitution> validator(ValidatorFactory factory) {
		return factory.<Substitution>create(SubstitutionValidator.class);
	}

	@Override
	public Validator<? super Substitution> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Substitution>create(SubstitutionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Substitution> validator() {
		return new SubstitutionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Substitution> typeFormatValidator() {
		return new SubstitutionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Substitution, Set<String>> onlyExistsValidator() {
		return new SubstitutionOnlyExistsValidator();
	}
}
