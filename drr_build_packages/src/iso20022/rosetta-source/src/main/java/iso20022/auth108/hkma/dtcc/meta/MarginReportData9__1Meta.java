package iso20022.auth108.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.MarginReportData9__1;
import iso20022.auth108.hkma.dtcc.validation.MarginReportData9__1TypeFormatValidator;
import iso20022.auth108.hkma.dtcc.validation.MarginReportData9__1Validator;
import iso20022.auth108.hkma.dtcc.validation.exists.MarginReportData9__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginReportData9__1.class)
public class MarginReportData9__1Meta implements RosettaMetaData<MarginReportData9__1> {

	@Override
	public List<Validator<? super MarginReportData9__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginReportData9__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginReportData9__1> validator(ValidatorFactory factory) {
		return factory.<MarginReportData9__1>create(MarginReportData9__1Validator.class);
	}

	@Override
	public Validator<? super MarginReportData9__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginReportData9__1>create(MarginReportData9__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData9__1> validator() {
		return new MarginReportData9__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginReportData9__1> typeFormatValidator() {
		return new MarginReportData9__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginReportData9__1, Set<String>> onlyExistsValidator() {
		return new MarginReportData9__1OnlyExistsValidator();
	}
}
