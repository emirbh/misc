package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.AssetClassCommodityIndex1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is index.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityIndex1", builder=AssetClassCommodityIndex1.AssetClassCommodityIndex1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityIndex1", model="iso20022", builder=AssetClassCommodityIndex1.AssetClassCommodityIndex1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityIndex1 extends RosettaModelObject {

	AssetClassCommodityIndex1Meta metaData = new AssetClassCommodityIndex1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType16Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityIndex1 build();
	
	AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder toBuilder();
	
	static AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder builder() {
		return new AssetClassCommodityIndex1.AssetClassCommodityIndex1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityIndex1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityIndex1> getType() {
		return AssetClassCommodityIndex1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType16Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityIndex1Builder extends AssetClassCommodityIndex1, RosettaModelObjectBuilder {
		AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder setBasePdct(AssetClassProductType16Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType16Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityIndex1  ***********************/
	class AssetClassCommodityIndex1Impl implements AssetClassCommodityIndex1 {
		private final AssetClassProductType16Code basePdct;
		
		protected AssetClassCommodityIndex1Impl(AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType16Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityIndex1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder toBuilder() {
			AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndex1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityIndex1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityIndex1  ***********************/
	class AssetClassCommodityIndex1BuilderImpl implements AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder {
	
		protected AssetClassProductType16Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType16Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder setBasePdct(AssetClassProductType16Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityIndex1 build() {
			return new AssetClassCommodityIndex1.AssetClassCommodityIndex1Impl(this);
		}
		
		@Override
		public AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder o = (AssetClassCommodityIndex1.AssetClassCommodityIndex1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityIndex1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityIndex1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
