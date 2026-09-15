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
import iso20022.auth030.esma.meta.AgriculturalCommodityOilSeed2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type oil seed.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityOilSeed2", builder=AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityOilSeed2", model="iso20022", builder=AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityOilSeed2 extends RosettaModelObject {

	AgriculturalCommodityOilSeed2Meta metaData = new AgriculturalCommodityOilSeed2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType1Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType1Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityOilSeed2 build();
	
	AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder toBuilder();
	
	static AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder builder() {
		return new AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityOilSeed2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityOilSeed2> getType() {
		return AgriculturalCommodityOilSeed2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType1Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType1Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityOilSeed2Builder extends AgriculturalCommodityOilSeed2, RosettaModelObjectBuilder {
		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setSubPdct(AssetClassSubProductType1Code subPdct);
		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setAddtlSubPdct(AssetClassDetailedSubProductType1Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType1Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType1Code.class, getAddtlSubPdct(), this);
		}
		

		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityOilSeed2  ***********************/
	class AgriculturalCommodityOilSeed2Impl implements AgriculturalCommodityOilSeed2 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType1Code subPdct;
		private final AssetClassDetailedSubProductType1Code addtlSubPdct;
		
		protected AgriculturalCommodityOilSeed2Impl(AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
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
		public AssetClassSubProductType1Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType1Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public AgriculturalCommodityOilSeed2 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder toBuilder() {
			AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityOilSeed2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityOilSeed2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityOilSeed2  ***********************/
	class AgriculturalCommodityOilSeed2BuilderImpl implements AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType1Code subPdct;
		protected AssetClassDetailedSubProductType1Code addtlSubPdct;
		
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
		public AssetClassSubProductType1Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType1Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setSubPdct(AssetClassSubProductType1Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder setAddtlSubPdct(AssetClassDetailedSubProductType1Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityOilSeed2 build() {
			return new AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Impl(this);
		}
		
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			if (getAddtlSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder o = (AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityOilSeed2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityOilSeed2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
