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
import iso20022.auth030.hkma.dtcc.meta.IndustrialProductCommodityConstruction2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an industrial product derivative of type construction.
 * @version ${project.version}
 */
@RosettaDataType(value="IndustrialProductCommodityConstruction2", builder=IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="IndustrialProductCommodityConstruction2", model="iso20022", builder=IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2BuilderImpl.class, version="${project.version}")
public interface IndustrialProductCommodityConstruction2 extends RosettaModelObject {

	IndustrialProductCommodityConstruction2Meta metaData = new IndustrialProductCommodityConstruction2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType6Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType33Code getSubPdct();

	/*********************** Build Methods  ***********************/
	IndustrialProductCommodityConstruction2 build();
	
	IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder toBuilder();
	
	static IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder builder() {
		return new IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndustrialProductCommodityConstruction2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndustrialProductCommodityConstruction2> getType() {
		return IndustrialProductCommodityConstruction2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType6Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType33Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndustrialProductCommodityConstruction2Builder extends IndustrialProductCommodityConstruction2, RosettaModelObjectBuilder {
		IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder setBasePdct(AssetClassProductType6Code basePdct);
		IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder setSubPdct(AssetClassSubProductType33Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType6Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType33Code.class, getSubPdct(), this);
		}
		

		IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder prune();
	}

	/*********************** Immutable Implementation of IndustrialProductCommodityConstruction2  ***********************/
	class IndustrialProductCommodityConstruction2Impl implements IndustrialProductCommodityConstruction2 {
		private final AssetClassProductType6Code basePdct;
		private final AssetClassSubProductType33Code subPdct;
		
		protected IndustrialProductCommodityConstruction2Impl(IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType6Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType33Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public IndustrialProductCommodityConstruction2 build() {
			return this;
		}
		
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder toBuilder() {
			IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustrialProductCommodityConstruction2 _that = getType().cast(o);
		
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
			return "IndustrialProductCommodityConstruction2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of IndustrialProductCommodityConstruction2  ***********************/
	class IndustrialProductCommodityConstruction2BuilderImpl implements IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder {
	
		protected AssetClassProductType6Code basePdct;
		protected AssetClassSubProductType33Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType6Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType33Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder setBasePdct(AssetClassProductType6Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder setSubPdct(AssetClassSubProductType33Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public IndustrialProductCommodityConstruction2 build() {
			return new IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Impl(this);
		}
		
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder prune() {
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
		public IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder o = (IndustrialProductCommodityConstruction2.IndustrialProductCommodityConstruction2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustrialProductCommodityConstruction2 _that = getType().cast(o);
		
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
			return "IndustrialProductCommodityConstruction2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
