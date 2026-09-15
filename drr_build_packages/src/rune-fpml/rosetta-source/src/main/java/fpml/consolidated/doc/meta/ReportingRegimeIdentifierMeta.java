package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.validation.ReportingRegimeIdentifierTypeFormatValidator;
import fpml.consolidated.doc.validation.ReportingRegimeIdentifierValidator;
import fpml.consolidated.doc.validation.datarule.ReportingRegimeIdentifierChoice;
import fpml.consolidated.doc.validation.exists.ReportingRegimeIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingRegimeIdentifier.class)
public class ReportingRegimeIdentifierMeta implements RosettaMetaData<ReportingRegimeIdentifier> {

	@Override
	public List<Validator<? super ReportingRegimeIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportingRegimeIdentifier>create(ReportingRegimeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingRegimeIdentifier> validator(ValidatorFactory factory) {
		return factory.<ReportingRegimeIdentifier>create(ReportingRegimeIdentifierValidator.class);
	}

	@Override
	public Validator<? super ReportingRegimeIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingRegimeIdentifier>create(ReportingRegimeIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegimeIdentifier> validator() {
		return new ReportingRegimeIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegimeIdentifier> typeFormatValidator() {
		return new ReportingRegimeIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeIdentifier, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeIdentifierOnlyExistsValidator();
	}
}
