package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.PolypropyleneCommodityPlastic2__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a polypropylene derivative of type plastic.
 * @version ${project.version}
 */
@RosettaDataType(value="PolypropyleneCommodityPlastic2__1", builder=PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PolypropyleneCommodityPlastic2__1", model="iso20022", builder=PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1BuilderImpl.class, version="${project.version}")
public interface PolypropyleneCommodityPlastic2__1 extends RosettaModelObject {

	PolypropyleneCommodityPlastic2__1Meta metaData = new PolypropyleneCommodityPlastic2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType9Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType18Code getSubPdct();

	/*********************** Build Methods  ***********************/
	PolypropyleneCommodityPlastic2__1 build();
	
	PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder toBuilder();
	
	static PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder builder() {
		return new PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PolypropyleneCommodityPlastic2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PolypropyleneCommodityPlastic2__1> getType() {
		return PolypropyleneCommodityPlastic2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType9Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType18Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PolypropyleneCommodityPlastic2__1Builder extends PolypropyleneCommodityPlastic2__1, RosettaModelObjectBuilder {
		PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder setBasePdct(AssetClassProductType9Code basePdct);
		PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder setSubPdct(AssetClassSubProductType18Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType9Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType18Code.class, getSubPdct(), this);
		}
		

		PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder prune();
	}

	/*********************** Immutable Implementation of PolypropyleneCommodityPlastic2__1  ***********************/
	class PolypropyleneCommodityPlastic2__1Impl implements PolypropyleneCommodityPlastic2__1 {
		private final AssetClassProductType9Code basePdct;
		private final AssetClassSubProductType18Code subPdct;
		
		protected PolypropyleneCommodityPlastic2__1Impl(PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType9Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType18Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public PolypropyleneCommodityPlastic2__1 build() {
			return this;
		}
		
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder toBuilder() {
			PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PolypropyleneCommodityPlastic2__1 _that = getType().cast(o);
		
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
			return "PolypropyleneCommodityPlastic2__1 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of PolypropyleneCommodityPlastic2__1  ***********************/
	class PolypropyleneCommodityPlastic2__1BuilderImpl implements PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder {
	
		protected AssetClassProductType9Code basePdct;
		protected AssetClassSubProductType18Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType9Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType18Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder setBasePdct(AssetClassProductType9Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("subPdct")
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder setSubPdct(AssetClassSubProductType18Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public PolypropyleneCommodityPlastic2__1 build() {
			return new PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Impl(this);
		}
		
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder prune() {
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
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder o = (PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PolypropyleneCommodityPlastic2__1 _that = getType().cast(o);
		
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
			return "PolypropyleneCommodityPlastic2__1Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
