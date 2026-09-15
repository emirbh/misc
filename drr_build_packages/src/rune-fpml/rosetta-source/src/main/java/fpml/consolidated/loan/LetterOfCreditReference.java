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
import fpml.consolidated.loan.meta.LetterOfCreditReferenceMeta;
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
 * Provision A reference to a letter of credit.
 *
 */
@RosettaDataType(value="LetterOfCreditReference", builder=LetterOfCreditReference.LetterOfCreditReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LetterOfCreditReference", model="fpml", builder=LetterOfCreditReference.LetterOfCreditReferenceBuilderImpl.class, version="2.1.1")
public interface LetterOfCreditReference extends Reference {

	LetterOfCreditReferenceMeta metaData = new LetterOfCreditReferenceMeta();

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
	LetterOfCreditReference build();
	
	LetterOfCreditReference.LetterOfCreditReferenceBuilder toBuilder();
	
	static LetterOfCreditReference.LetterOfCreditReferenceBuilder builder() {
		return new LetterOfCreditReference.LetterOfCreditReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LetterOfCreditReference> getType() {
		return LetterOfCreditReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditReferenceBuilder extends LetterOfCreditReference, Reference.ReferenceBuilder {
		LetterOfCreditReference.LetterOfCreditReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LetterOfCreditReference.LetterOfCreditReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditReference  ***********************/
	class LetterOfCreditReferenceImpl extends Reference.ReferenceImpl implements LetterOfCreditReference {
		private final String href;
		
		protected LetterOfCreditReferenceImpl(LetterOfCreditReference.LetterOfCreditReferenceBuilder builder) {
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
		public LetterOfCreditReference build() {
			return this;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder toBuilder() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditReference.LetterOfCreditReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCreditReference _that = getType().cast(o);
		
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
			return "LetterOfCreditReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCreditReference  ***********************/
	class LetterOfCreditReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements LetterOfCreditReference.LetterOfCreditReferenceBuilder {
	
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
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public LetterOfCreditReference build() {
			return new LetterOfCreditReference.LetterOfCreditReferenceImpl(this);
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder prune() {
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
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LetterOfCreditReference.LetterOfCreditReferenceBuilder o = (LetterOfCreditReference.LetterOfCreditReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCreditReference _that = getType().cast(o);
		
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
			return "LetterOfCreditReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
