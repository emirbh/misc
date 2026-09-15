package iso20022.unavista.csv.esma.mifir.rts22.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.unavista.csv.esma.mifir.rts22.MIFIRUnavistaCSVDocument;
import iso20022.unavista.csv.esma.mifir.rts22.validation.MIFIRUnavistaCSVDocumentTypeFormatValidator;
import iso20022.unavista.csv.esma.mifir.rts22.validation.MIFIRUnavistaCSVDocumentValidator;
import iso20022.unavista.csv.esma.mifir.rts22.validation.exists.MIFIRUnavistaCSVDocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MIFIRUnavistaCSVDocument.class)
public class MIFIRUnavistaCSVDocumentMeta implements RosettaMetaData<MIFIRUnavistaCSVDocument> {

	@Override
	public List<Validator<? super MIFIRUnavistaCSVDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MIFIRUnavistaCSVDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MIFIRUnavistaCSVDocument> validator(ValidatorFactory factory) {
		return factory.<MIFIRUnavistaCSVDocument>create(MIFIRUnavistaCSVDocumentValidator.class);
	}

	@Override
	public Validator<? super MIFIRUnavistaCSVDocument> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MIFIRUnavistaCSVDocument>create(MIFIRUnavistaCSVDocumentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MIFIRUnavistaCSVDocument> validator() {
		return new MIFIRUnavistaCSVDocumentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MIFIRUnavistaCSVDocument> typeFormatValidator() {
		return new MIFIRUnavistaCSVDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MIFIRUnavistaCSVDocument, Set<String>> onlyExistsValidator() {
		return new MIFIRUnavistaCSVDocumentOnlyExistsValidator();
	}
}
