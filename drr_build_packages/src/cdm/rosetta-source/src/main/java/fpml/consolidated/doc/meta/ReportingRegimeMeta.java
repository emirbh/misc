package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.validation.ReportingRegimeTypeFormatValidator;
import fpml.consolidated.doc.validation.ReportingRegimeValidator;
import fpml.consolidated.doc.validation.datarule.ReportingRegimeChoice0;
import fpml.consolidated.doc.validation.datarule.ReportingRegimeChoice1;
import fpml.consolidated.doc.validation.datarule.ReportingRegimeChoice2;
import fpml.consolidated.doc.validation.exists.ReportingRegimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingRegime.class)
public class ReportingRegimeMeta implements RosettaMetaData<ReportingRegime> {

	@Override
	public List<Validator<? super ReportingRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportingRegime>create(ReportingRegimeChoice0.class),
			factory.<ReportingRegime>create(ReportingRegimeChoice1.class),
			factory.<ReportingRegime>create(ReportingRegimeChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super ReportingRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingRegime> validator(ValidatorFactory factory) {
		return factory.<ReportingRegime>create(ReportingRegimeValidator.class);
	}

	@Override
	public Validator<? super ReportingRegime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingRegime>create(ReportingRegimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegime> validator() {
		return new ReportingRegimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegime> typeFormatValidator() {
		return new ReportingRegimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegime, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeOnlyExistsValidator();
	}
}
