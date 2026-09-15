package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.DocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Document", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Document", model="iso20022", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
public interface Document extends RosettaModelObject {

	DocumentMeta metaData = new DocumentMeta();

	/*********************** Getter Methods  ***********************/
	DerivativesTradeReportV04 getDerivsTradRpt();

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
		processRosetta(path.newSubPath("derivsTradRpt"), processor, DerivativesTradeReportV04.class, getDerivsTradRpt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		DerivativesTradeReportV04.DerivativesTradeReportV04Builder getOrCreateDerivsTradRpt();
		@Override
		DerivativesTradeReportV04.DerivativesTradeReportV04Builder getDerivsTradRpt();
		Document.DocumentBuilder setDerivsTradRpt(DerivativesTradeReportV04 derivsTradRpt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("derivsTradRpt"), processor, DerivativesTradeReportV04.DerivativesTradeReportV04Builder.class, getDerivsTradRpt());
		}
		

		Document.DocumentBuilder prune();
	}

	/*********************** Immutable Implementation of Document  ***********************/
	class DocumentImpl implements Document {
		private final DerivativesTradeReportV04 derivsTradRpt;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.derivsTradRpt = ofNullable(builder.getDerivsTradRpt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("derivsTradRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivsTradRpt")
		public DerivativesTradeReportV04 getDerivsTradRpt() {
			return derivsTradRpt;
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
			ofNullable(getDerivsTradRpt()).ifPresent(builder::setDerivsTradRpt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(derivsTradRpt, _that.getDerivsTradRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivsTradRpt != null ? derivsTradRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"derivsTradRpt=" + this.derivsTradRpt +
			'}';
		}
	}

	/*********************** Builder Implementation of Document  ***********************/
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected DerivativesTradeReportV04.DerivativesTradeReportV04Builder derivsTradRpt;
		
		@Override
		@RosettaAttribute("derivsTradRpt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivsTradRpt")
		public DerivativesTradeReportV04.DerivativesTradeReportV04Builder getDerivsTradRpt() {
			return derivsTradRpt;
		}
		
		@Override
		public DerivativesTradeReportV04.DerivativesTradeReportV04Builder getOrCreateDerivsTradRpt() {
			DerivativesTradeReportV04.DerivativesTradeReportV04Builder result;
			if (derivsTradRpt!=null) {
				result = derivsTradRpt;
			}
			else {
				result = derivsTradRpt = DerivativesTradeReportV04.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("derivsTradRpt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivsTradRpt")
		@Override
		public Document.DocumentBuilder setDerivsTradRpt(DerivativesTradeReportV04 _derivsTradRpt) {
			this.derivsTradRpt = _derivsTradRpt == null ? null : _derivsTradRpt.toBuilder();
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
			if (derivsTradRpt!=null && !derivsTradRpt.prune().hasData()) derivsTradRpt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDerivsTradRpt()!=null && getDerivsTradRpt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			merger.mergeRosetta(getDerivsTradRpt(), o.getDerivsTradRpt(), this::setDerivsTradRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(derivsTradRpt, _that.getDerivsTradRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivsTradRpt != null ? derivsTradRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"derivsTradRpt=" + this.derivsTradRpt +
			'}';
		}
	}
}
