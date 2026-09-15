package iso20022.auth108.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.validation.MarginReportData7__1TypeFormatValidator;
import iso20022.auth108.fca.validation.MarginReportData7__1Validator;
import iso20022.auth108.fca.validation.exists.MarginReportData7__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginReportData7__1.class)
public class MarginReportData7__1Meta implements RosettaMetaData<MarginReportData7__1> {

	@Override
	public List<Validator<? super MarginReportData7__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginReportData7__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginReportData7__1> validator(ValidatorFactory factory) {
		return factory.<MarginReportData7__1>create(MarginReportData7__1Validator.class);
	}

	@Override
	public Validator<? super MarginReportData7__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginReportData7__1>create(MarginReportData7__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData7__1> validator() {
		return new MarginReportData7__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData7__1> typeFormatValidator() {
		return new MarginReportData7__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginReportData7__1, Set<String>> onlyExistsValidator() {
		return new MarginReportData7__1OnlyExistsValidator();
	}
}
