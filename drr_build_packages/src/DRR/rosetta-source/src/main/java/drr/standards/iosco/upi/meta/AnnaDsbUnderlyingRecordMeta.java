package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlyingRecord;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingRecordTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingRecordValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlyingRecordOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlyingRecord.class)
public class AnnaDsbUnderlyingRecordMeta implements RosettaMetaData<AnnaDsbUnderlyingRecord> {

	@Override
	public List<Validator<? super AnnaDsbUnderlyingRecord>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlyingRecord, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlyingRecord> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingRecord>create(AnnaDsbUnderlyingRecordValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlyingRecord> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingRecord>create(AnnaDsbUnderlyingRecordTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingRecord> validator() {
		return new AnnaDsbUnderlyingRecordValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingRecord> typeFormatValidator() {
		return new AnnaDsbUnderlyingRecordTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlyingRecord, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlyingRecordOnlyExistsValidator();
	}
}
