package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanCovenantObligationReferenceMeta;
import fpml.consolidated.shared.Reference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A reference to a loan covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationReference", builder=LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationReference", model="fpml", builder=LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationReference extends Reference {

	LoanCovenantObligationReferenceMeta metaData = new LoanCovenantObligationReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationReference build();
	
	LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder toBuilder();
	
	static LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder builder() {
		return new LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationReference> getType() {
		return LoanCovenantObligationReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationReferenceBuilder extends LoanCovenantObligationReference, Reference.ReferenceBuilder {
		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationReference  ***********************/
	class LoanCovenantObligationReferenceImpl extends Reference.ReferenceImpl implements LoanCovenantObligationReference {
		private final String href;
		
		protected LoanCovenantObligationReferenceImpl(LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LoanCovenantObligationReference build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder toBuilder() {
			LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationReference  ***********************/
	class LoanCovenantObligationReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder {
	
		protected String href;
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("href")
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public LoanCovenantObligationReference build() {
			return new LoanCovenantObligationReference.LoanCovenantObligationReferenceImpl(this);
		}
		
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder o = (LoanCovenantObligationReference.LoanCovenantObligationReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
