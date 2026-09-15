package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.AgriculturalCommodityPotato2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type potato.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityPotato2", builder=AgriculturalCommodityPotato2.AgriculturalCommodityPotato2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityPotato2", model="iso20022", builder=AgriculturalCommodityPotato2.AgriculturalCommodityPotato2BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityPotato2 extends RosettaModelObject {

	AgriculturalCommodityPotato2Meta metaData = new AgriculturalCommodityPotato2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType45Code getSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityPotato2 build();
	
	AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder toBuilder();
	
	static AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder builder() {
		return new AgriculturalCommodityPotato2.AgriculturalCommodityPotato2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityPotato2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityPotato2> getType() {
		return AgriculturalCommodityPotato2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType45Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityPotato2Builder extends AgriculturalCommodityPotato2, RosettaModelObjectBuilder {
		AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder setSubPdct(AssetClassSubProductType45Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType45Code.class, getSubPdct(), this);
		}
		

		AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityPotato2  ***********************/
	class AgriculturalCommodityPotato2Impl implements AgriculturalCommodityPotato2 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType45Code subPdct;
		
		protected AgriculturalCommodityPotato2Impl(AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder builder) {
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
		public AssetClassSubProductType45Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public AgriculturalCommodityPotato2 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder toBuilder() {
			AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityPotato2 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityPotato2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityPotato2  ***********************/
	class AgriculturalCommodityPotato2BuilderImpl implements AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType45Code subPdct;
		
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
		public AssetClassSubProductType45Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder setSubPdct(AssetClassSubProductType45Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityPotato2 build() {
			return new AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Impl(this);
		}
		
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder prune() {
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
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder o = (AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityPotato2 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityPotato2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
