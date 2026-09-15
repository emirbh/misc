package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.TechnicalRecordId;
import drr.regulation.common.validation.TechnicalRecordIdTypeFormatValidator;
import drr.regulation.common.validation.TechnicalRecordIdValidator;
import drr.regulation.common.validation.datarule.TechnicalRecordIdIsUnique;
import drr.regulation.common.validation.exists.TechnicalRecordIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=TechnicalRecordId.class)
public class TechnicalRecordIdMeta implements RosettaMetaData<TechnicalRecordId> {

	@Override
	public List<Validator<? super TechnicalRecordId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TechnicalRecordId>create(TechnicalRecordIdIsUnique.class)
		);
	}
	
	@Override
	public List<Function<? super TechnicalRecordId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TechnicalRecordId> validator(ValidatorFactory factory) {
		return factory.<TechnicalRecordId>create(TechnicalRecordIdValidator.class);
	}

	@Override
	public Validator<? super TechnicalRecordId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TechnicalRecordId>create(TechnicalRecordIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalRecordId> validator() {
		return new TechnicalRecordIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalRecordId> typeFormatValidator() {
		return new TechnicalRecordIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TechnicalRecordId, Set<String>> onlyExistsValidator() {
		return new TechnicalRecordIdOnlyExistsValidator();
	}
}
