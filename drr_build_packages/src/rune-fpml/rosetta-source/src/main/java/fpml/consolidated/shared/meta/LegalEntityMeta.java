package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.validation.LegalEntityTypeFormatValidator;
import fpml.consolidated.shared.validation.LegalEntityValidator;
import fpml.consolidated.shared.validation.datarule.LegalEntityChoice;
import fpml.consolidated.shared.validation.exists.LegalEntityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegalEntity.class)
public class LegalEntityMeta implements RosettaMetaData<LegalEntity> {

	@Override
	public List<Validator<? super LegalEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegalEntity>create(LegalEntityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LegalEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalEntity> validator(ValidatorFactory factory) {
		return factory.<LegalEntity>create(LegalEntityValidator.class);
	}

	@Override
	public Validator<? super LegalEntity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalEntity>create(LegalEntityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalEntity> validator() {
		return new LegalEntityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalEntity> typeFormatValidator() {
		return new LegalEntityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalEntity, Set<String>> onlyExistsValidator() {
		return new LegalEntityOnlyExistsValidator();
	}
}
