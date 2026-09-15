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
import iso20022.auth030.hkma.dtcc.meta.AgriculturalCommoditySeafood2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type seafood.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommoditySeafood2", builder=AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommoditySeafood2", model="iso20022", builder=AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommoditySeafood2 extends RosettaModelObject {

	AgriculturalCommoditySeafood2Meta metaData = new AgriculturalCommoditySeafood2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType23Code getSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommoditySeafood2 build();
	
	AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder toBuilder();
	
	static AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder builder() {
		return new AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommoditySeafood2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommoditySeafood2> getType() {
		return AgriculturalCommoditySeafood2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType23Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommoditySeafood2Builder extends AgriculturalCommoditySeafood2, RosettaModelObjectBuilder {
		AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder setSubPdct(AssetClassSubProductType23Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType23Code.class, getSubPdct(), this);
		}
		

		AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommoditySeafood2  ***********************/
	class AgriculturalCommoditySeafood2Impl implements AgriculturalCommoditySeafood2 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType23Code subPdct;
		
		protected AgriculturalCommoditySeafood2Impl(AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder builder) {
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
		public AssetClassSubProductType23Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public AgriculturalCommoditySeafood2 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder toBuilder() {
			AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommoditySeafood2 _that = getType().cast(o);
		
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
			return "AgriculturalCommoditySeafood2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommoditySeafood2  ***********************/
	class AgriculturalCommoditySeafood2BuilderImpl implements AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType23Code subPdct;
		
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
		public AssetClassSubProductType23Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder setSubPdct(AssetClassSubProductType23Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommoditySeafood2 build() {
			return new AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Impl(this);
		}
		
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder prune() {
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
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder o = (AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommoditySeafood2 _that = getType().cast(o);
		
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
			return "AgriculturalCommoditySeafood2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
