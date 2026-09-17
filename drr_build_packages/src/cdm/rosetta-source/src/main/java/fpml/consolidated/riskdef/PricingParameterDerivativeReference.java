package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.PricingParameterDerivativeReferenceMeta;
import fpml.consolidated.shared.Reference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to a partial derivative.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a partial derivative.
 *
 */
@RosettaDataType(value="PricingParameterDerivativeReference", builder=PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingParameterDerivativeReference", model="fpml", builder=PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilderImpl.class, version="2.1.1")
public interface PricingParameterDerivativeReference extends Reference {

	PricingParameterDerivativeReferenceMeta metaData = new PricingParameterDerivativeReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
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
	PricingParameterDerivativeReference build();
	
	PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder toBuilder();
	
	static PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder builder() {
		return new PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingParameterDerivativeReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingParameterDerivativeReference> getType() {
		return PricingParameterDerivativeReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingParameterDerivativeReferenceBuilder extends PricingParameterDerivativeReference, Reference.ReferenceBuilder {
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PricingParameterDerivativeReference  ***********************/
	class PricingParameterDerivativeReferenceImpl extends Reference.ReferenceImpl implements PricingParameterDerivativeReference {
		private final String href;
		
		protected PricingParameterDerivativeReferenceImpl(PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder builder) {
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
		public PricingParameterDerivativeReference build() {
			return this;
		}
		
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder toBuilder() {
			PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingParameterDerivativeReference _that = getType().cast(o);
		
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
			return "PricingParameterDerivativeReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricingParameterDerivativeReference  ***********************/
	class PricingParameterDerivativeReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder {
	
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
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public PricingParameterDerivativeReference build() {
			return new PricingParameterDerivativeReference.PricingParameterDerivativeReferenceImpl(this);
		}
		
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder prune() {
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
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder o = (PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricingParameterDerivativeReference _that = getType().cast(o);
		
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
			return "PricingParameterDerivativeReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
