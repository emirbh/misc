package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.AgriculturalCommodityLiveStock2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type livestock.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityLiveStock2", builder=AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityLiveStock2", model="iso20022", builder=AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityLiveStock2 extends RosettaModelObject {

	AgriculturalCommodityLiveStock2Meta metaData = new AgriculturalCommodityLiveStock2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType22Code getSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityLiveStock2 build();
	
	AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder toBuilder();
	
	static AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder builder() {
		return new AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityLiveStock2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityLiveStock2> getType() {
		return AgriculturalCommodityLiveStock2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType22Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityLiveStock2Builder extends AgriculturalCommodityLiveStock2, RosettaModelObjectBuilder {
		AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder setSubPdct(AssetClassSubProductType22Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType22Code.class, getSubPdct(), this);
		}
		

		AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityLiveStock2  ***********************/
	class AgriculturalCommodityLiveStock2Impl implements AgriculturalCommodityLiveStock2 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType22Code subPdct;
		
		protected AgriculturalCommodityLiveStock2Impl(AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType1Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType22Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public AgriculturalCommodityLiveStock2 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder toBuilder() {
			AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityLiveStock2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityLiveStock2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityLiveStock2  ***********************/
	class AgriculturalCommodityLiveStock2BuilderImpl implements AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType22Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType1Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType22Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder setSubPdct(AssetClassSubProductType22Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityLiveStock2 build() {
			return new AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Impl(this);
		}
		
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder o = (AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityLiveStock2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityLiveStock2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
