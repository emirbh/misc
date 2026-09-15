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
import fpml.consolidated.riskdef.meta.AssetOrTermPointOrPricingStructureReferenceMeta;
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
 * Provision Reference to an underlying asset, term point or pricing structure (yield curve).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to an underlying asset, term point or pricing structure (yield curve).
 *
 */
@RosettaDataType(value="AssetOrTermPointOrPricingStructureReference", builder=AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssetOrTermPointOrPricingStructureReference", model="fpml", builder=AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilderImpl.class, version="2.1.1")
public interface AssetOrTermPointOrPricingStructureReference extends Reference {

	AssetOrTermPointOrPricingStructureReferenceMeta metaData = new AssetOrTermPointOrPricingStructureReferenceMeta();

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
	AssetOrTermPointOrPricingStructureReference build();
	
	AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder toBuilder();
	
	static AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder builder() {
		return new AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetOrTermPointOrPricingStructureReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetOrTermPointOrPricingStructureReference> getType() {
		return AssetOrTermPointOrPricingStructureReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetOrTermPointOrPricingStructureReferenceBuilder extends AssetOrTermPointOrPricingStructureReference, Reference.ReferenceBuilder {
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetOrTermPointOrPricingStructureReference  ***********************/
	class AssetOrTermPointOrPricingStructureReferenceImpl extends Reference.ReferenceImpl implements AssetOrTermPointOrPricingStructureReference {
		private final String href;
		
		protected AssetOrTermPointOrPricingStructureReferenceImpl(AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder builder) {
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
		public AssetOrTermPointOrPricingStructureReference build() {
			return this;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder toBuilder() {
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetOrTermPointOrPricingStructureReference _that = getType().cast(o);
		
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
			return "AssetOrTermPointOrPricingStructureReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AssetOrTermPointOrPricingStructureReference  ***********************/
	class AssetOrTermPointOrPricingStructureReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder {
	
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
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference build() {
			return new AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceImpl(this);
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder prune() {
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
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder o = (AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AssetOrTermPointOrPricingStructureReference _that = getType().cast(o);
		
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
			return "AssetOrTermPointOrPricingStructureReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
