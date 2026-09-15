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
import iso20022.auth030.hkma.tr.meta.FreightCommodityContainerShip2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a freight derivative of type container ships.
 * @version ${project.version}
 */
@RosettaDataType(value="FreightCommodityContainerShip2", builder=FreightCommodityContainerShip2.FreightCommodityContainerShip2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FreightCommodityContainerShip2", model="iso20022", builder=FreightCommodityContainerShip2.FreightCommodityContainerShip2BuilderImpl.class, version="${project.version}")
public interface FreightCommodityContainerShip2 extends RosettaModelObject {

	FreightCommodityContainerShip2Meta metaData = new FreightCommodityContainerShip2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType4Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType46Code getSubPdct();

	/*********************** Build Methods  ***********************/
	FreightCommodityContainerShip2 build();
	
	FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder toBuilder();
	
	static FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder builder() {
		return new FreightCommodityContainerShip2.FreightCommodityContainerShip2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FreightCommodityContainerShip2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FreightCommodityContainerShip2> getType() {
		return FreightCommodityContainerShip2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType46Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FreightCommodityContainerShip2Builder extends FreightCommodityContainerShip2, RosettaModelObjectBuilder {
		FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder setBasePdct(AssetClassProductType4Code basePdct);
		FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder setSubPdct(AssetClassSubProductType46Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType4Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType46Code.class, getSubPdct(), this);
		}
		

		FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder prune();
	}

	/*********************** Immutable Implementation of FreightCommodityContainerShip2  ***********************/
	class FreightCommodityContainerShip2Impl implements FreightCommodityContainerShip2 {
		private final AssetClassProductType4Code basePdct;
		private final AssetClassSubProductType46Code subPdct;
		
		protected FreightCommodityContainerShip2Impl(FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder builder) {
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
		public AssetClassSubProductType46Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public FreightCommodityContainerShip2 build() {
			return this;
		}
		
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder toBuilder() {
			FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityContainerShip2 _that = getType().cast(o);
		
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
			return "FreightCommodityContainerShip2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of FreightCommodityContainerShip2  ***********************/
	class FreightCommodityContainerShip2BuilderImpl implements FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder {
	
		protected AssetClassProductType4Code basePdct;
		protected AssetClassSubProductType46Code subPdct;
		
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
		public AssetClassSubProductType46Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder setBasePdct(AssetClassProductType4Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder setSubPdct(AssetClassSubProductType46Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public FreightCommodityContainerShip2 build() {
			return new FreightCommodityContainerShip2.FreightCommodityContainerShip2Impl(this);
		}
		
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder prune() {
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
		public FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder o = (FreightCommodityContainerShip2.FreightCommodityContainerShip2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FreightCommodityContainerShip2 _that = getType().cast(o);
		
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
			return "FreightCommodityContainerShip2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
