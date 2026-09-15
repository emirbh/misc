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
import iso20022.auth030.hkma.dtcc.meta.AgriculturalCommodityForestry2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type forestry.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityForestry2", builder=AgriculturalCommodityForestry2.AgriculturalCommodityForestry2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityForestry2", model="iso20022", builder=AgriculturalCommodityForestry2.AgriculturalCommodityForestry2BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityForestry2 extends RosettaModelObject {

	AgriculturalCommodityForestry2Meta metaData = new AgriculturalCommodityForestry2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType21Code getSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityForestry2 build();
	
	AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder toBuilder();
	
	static AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder builder() {
		return new AgriculturalCommodityForestry2.AgriculturalCommodityForestry2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityForestry2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityForestry2> getType() {
		return AgriculturalCommodityForestry2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType21Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityForestry2Builder extends AgriculturalCommodityForestry2, RosettaModelObjectBuilder {
		AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder setSubPdct(AssetClassSubProductType21Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType21Code.class, getSubPdct(), this);
		}
		

		AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityForestry2  ***********************/
	class AgriculturalCommodityForestry2Impl implements AgriculturalCommodityForestry2 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType21Code subPdct;
		
		protected AgriculturalCommodityForestry2Impl(AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder builder) {
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
		public AssetClassSubProductType21Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public AgriculturalCommodityForestry2 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder toBuilder() {
			AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityForestry2 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityForestry2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityForestry2  ***********************/
	class AgriculturalCommodityForestry2BuilderImpl implements AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType21Code subPdct;
		
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
		public AssetClassSubProductType21Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder setSubPdct(AssetClassSubProductType21Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityForestry2 build() {
			return new AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Impl(this);
		}
		
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder prune() {
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
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder o = (AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityForestry2 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityForestry2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
