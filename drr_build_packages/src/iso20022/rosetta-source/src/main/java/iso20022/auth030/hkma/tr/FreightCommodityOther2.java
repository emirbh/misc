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
import iso20022.auth030.hkma.tr.meta.FreightCommodityOther2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Other freight commodity derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="FreightCommodityOther2", builder=FreightCommodityOther2.FreightCommodityOther2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FreightCommodityOther2", model="iso20022", builder=FreightCommodityOther2.FreightCommodityOther2BuilderImpl.class, version="${project.version}")
public interface FreightCommodityOther2 extends RosettaModelObject {

	FreightCommodityOther2Meta metaData = new FreightCommodityOther2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType4Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	FreightCommodityOther2 build();
	
	FreightCommodityOther2.FreightCommodityOther2Builder toBuilder();
	
	static FreightCommodityOther2.FreightCommodityOther2Builder builder() {
		return new FreightCommodityOther2.FreightCommodityOther2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FreightCommodityOther2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FreightCommodityOther2> getType() {
		return FreightCommodityOther2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FreightCommodityOther2Builder extends FreightCommodityOther2, RosettaModelObjectBuilder {
		FreightCommodityOther2.FreightCommodityOther2Builder setBasePdct(AssetClassProductType4Code basePdct);
		FreightCommodityOther2.FreightCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		FreightCommodityOther2.FreightCommodityOther2Builder prune();
	}

	/*********************** Immutable Implementation of FreightCommodityOther2  ***********************/
	class FreightCommodityOther2Impl implements FreightCommodityOther2 {
		private final AssetClassProductType4Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected FreightCommodityOther2Impl(FreightCommodityOther2.FreightCommodityOther2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType4Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public FreightCommodityOther2 build() {
			return this;
		}
		
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder toBuilder() {
			FreightCommodityOther2.FreightCommodityOther2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FreightCommodityOther2.FreightCommodityOther2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityOther2 _that = getType().cast(o);
		
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
			return "FreightCommodityOther2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FreightCommodityOther2  ***********************/
	class FreightCommodityOther2BuilderImpl implements FreightCommodityOther2.FreightCommodityOther2Builder {
	
		protected AssetClassProductType4Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType4Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder setBasePdct(AssetClassProductType4Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public FreightCommodityOther2 build() {
			return new FreightCommodityOther2.FreightCommodityOther2Impl(this);
		}
		
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FreightCommodityOther2.FreightCommodityOther2Builder prune() {
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
		public FreightCommodityOther2.FreightCommodityOther2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FreightCommodityOther2.FreightCommodityOther2Builder o = (FreightCommodityOther2.FreightCommodityOther2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityOther2 _that = getType().cast(o);
		
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
			return "FreightCommodityOther2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
