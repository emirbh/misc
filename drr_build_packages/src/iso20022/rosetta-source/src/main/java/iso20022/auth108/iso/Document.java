package iso20022.auth108.iso;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth108.iso.meta.DocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The DerivativesTradeMarginDataReport message is sent by the report submitting entity to the trade repository (TR) to report the margins exchanged in relation to the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable. The DerivativesTradeMarginDataReport message is sent by the report submitting entity to the trade repository (TR) to report the margins exchanged in relation to the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="Document", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Document", model="iso20022", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
public interface Document extends RosettaModelObject {

	DocumentMeta metaData = new DocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The DerivativesTradeMarginDataReport message is sent by the report submitting entity to the trade repository (TR) to report the margins exchanged in relation to the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable.
	 */
	DerivativesTradeMarginDataReportV01 getDerivsTradMrgnDataRpt();

	/*********************** Build Methods  ***********************/
	Document build();
	
	Document.DocumentBuilder toBuilder();
	
	static Document.DocumentBuilder builder() {
		return new Document.DocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Document> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Document> getType() {
		return Document.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("derivsTradMrgnDataRpt"), processor, DerivativesTradeMarginDataReportV01.class, getDerivsTradMrgnDataRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder getOrCreateDerivsTradMrgnDataRpt();
		@Override
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder getDerivsTradMrgnDataRpt();
		Document.DocumentBuilder setDerivsTradMrgnDataRpt(DerivativesTradeMarginDataReportV01 derivsTradMrgnDataRpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("derivsTradMrgnDataRpt"), processor, DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder.class, getDerivsTradMrgnDataRpt());
		}
		

		Document.DocumentBuilder prune();
	}

	/*********************** Immutable Implementation of Document  ***********************/
	class DocumentImpl implements Document {
		private final DerivativesTradeMarginDataReportV01 derivsTradMrgnDataRpt;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.derivsTradMrgnDataRpt = ofNullable(builder.getDerivsTradMrgnDataRpt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("derivsTradMrgnDataRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivsTradMrgnDataRpt")
		public DerivativesTradeMarginDataReportV01 getDerivsTradMrgnDataRpt() {
			return derivsTradMrgnDataRpt;
		}
		
		@Override
		public Document build() {
			return this;
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			Document.DocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Document.DocumentBuilder builder) {
			ofNullable(getDerivsTradMrgnDataRpt()).ifPresent(builder::setDerivsTradMrgnDataRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(derivsTradMrgnDataRpt, _that.getDerivsTradMrgnDataRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivsTradMrgnDataRpt != null ? derivsTradMrgnDataRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"derivsTradMrgnDataRpt=" + this.derivsTradMrgnDataRpt +
			'}';
		}
	}

	/*********************** Builder Implementation of Document  ***********************/
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder derivsTradMrgnDataRpt;
		
		@Override
		@RosettaAttribute("derivsTradMrgnDataRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivsTradMrgnDataRpt")
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder getDerivsTradMrgnDataRpt() {
			return derivsTradMrgnDataRpt;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder getOrCreateDerivsTradMrgnDataRpt() {
			DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder result;
			if (derivsTradMrgnDataRpt!=null) {
				result = derivsTradMrgnDataRpt;
			}
			else {
				result = derivsTradMrgnDataRpt = DerivativesTradeMarginDataReportV01.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("derivsTradMrgnDataRpt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivsTradMrgnDataRpt")
		@Override
		public Document.DocumentBuilder setDerivsTradMrgnDataRpt(DerivativesTradeMarginDataReportV01 _derivsTradMrgnDataRpt) {
			this.derivsTradMrgnDataRpt = _derivsTradMrgnDataRpt == null ? null : _derivsTradMrgnDataRpt.toBuilder();
			return this;
		}
		
		@Override
		public Document build() {
			return new Document.DocumentImpl(this);
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder prune() {
			if (derivsTradMrgnDataRpt!=null && !derivsTradMrgnDataRpt.prune().hasData()) derivsTradMrgnDataRpt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDerivsTradMrgnDataRpt()!=null && getDerivsTradMrgnDataRpt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			merger.mergeRosetta(getDerivsTradMrgnDataRpt(), o.getDerivsTradMrgnDataRpt(), this::setDerivsTradMrgnDataRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(derivsTradMrgnDataRpt, _that.getDerivsTradMrgnDataRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivsTradMrgnDataRpt != null ? derivsTradMrgnDataRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"derivsTradMrgnDataRpt=" + this.derivsTradMrgnDataRpt +
			'}';
		}
	}
}
