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
import fpml.consolidated.loan.meta.LoanLegalActionReferenceMeta;
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
 * Provision A reference to a legal action.
 *
 */
@RosettaDataType(value="LoanLegalActionReference", builder=LoanLegalActionReference.LoanLegalActionReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionReference", model="fpml", builder=LoanLegalActionReference.LoanLegalActionReferenceBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionReference extends Reference {

	LoanLegalActionReferenceMeta metaData = new LoanLegalActionReferenceMeta();

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
	LoanLegalActionReference build();
	
	LoanLegalActionReference.LoanLegalActionReferenceBuilder toBuilder();
	
	static LoanLegalActionReference.LoanLegalActionReferenceBuilder builder() {
		return new LoanLegalActionReference.LoanLegalActionReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionReference> getType() {
		return LoanLegalActionReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionReferenceBuilder extends LoanLegalActionReference, Reference.ReferenceBuilder {
		LoanLegalActionReference.LoanLegalActionReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LoanLegalActionReference.LoanLegalActionReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionReference  ***********************/
	class LoanLegalActionReferenceImpl extends Reference.ReferenceImpl implements LoanLegalActionReference {
		private final String href;
		
		protected LoanLegalActionReferenceImpl(LoanLegalActionReference.LoanLegalActionReferenceBuilder builder) {
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
		public LoanLegalActionReference build() {
			return this;
		}
		
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder toBuilder() {
			LoanLegalActionReference.LoanLegalActionReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionReference.LoanLegalActionReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionReference _that = getType().cast(o);
		
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
			return "LoanLegalActionReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionReference  ***********************/
	class LoanLegalActionReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements LoanLegalActionReference.LoanLegalActionReferenceBuilder {
	
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
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public LoanLegalActionReference build() {
			return new LoanLegalActionReference.LoanLegalActionReferenceImpl(this);
		}
		
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder prune() {
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
		public LoanLegalActionReference.LoanLegalActionReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionReference.LoanLegalActionReferenceBuilder o = (LoanLegalActionReference.LoanLegalActionReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionReference _that = getType().cast(o);
		
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
			return "LoanLegalActionReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
