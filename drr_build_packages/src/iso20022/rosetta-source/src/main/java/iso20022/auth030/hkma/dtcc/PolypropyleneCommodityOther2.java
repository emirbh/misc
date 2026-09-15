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
import iso20022.auth030.hkma.dtcc.meta.PolypropyleneCommodityOther2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a propylene derivative of type recovered paper.
 * @version ${project.version}
 */
@RosettaDataType(value="PolypropyleneCommodityOther2", builder=PolypropyleneCommodityOther2.PolypropyleneCommodityOther2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PolypropyleneCommodityOther2", model="iso20022", builder=PolypropyleneCommodityOther2.PolypropyleneCommodityOther2BuilderImpl.class, version="${project.version}")
public interface PolypropyleneCommodityOther2 extends RosettaModelObject {

	PolypropyleneCommodityOther2Meta metaData = new PolypropyleneCommodityOther2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType9Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	PolypropyleneCommodityOther2 build();
	
	PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder toBuilder();
	
	static PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder builder() {
		return new PolypropyleneCommodityOther2.PolypropyleneCommodityOther2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PolypropyleneCommodityOther2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PolypropyleneCommodityOther2> getType() {
		return PolypropyleneCommodityOther2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType9Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PolypropyleneCommodityOther2Builder extends PolypropyleneCommodityOther2, RosettaModelObjectBuilder {
		PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder setBasePdct(AssetClassProductType9Code basePdct);
		PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType9Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder prune();
	}

	/*********************** Immutable Implementation of PolypropyleneCommodityOther2  ***********************/
	class PolypropyleneCommodityOther2Impl implements PolypropyleneCommodityOther2 {
		private final AssetClassProductType9Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected PolypropyleneCommodityOther2Impl(PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder builder) {
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
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public PolypropyleneCommodityOther2 build() {
			return this;
		}
		
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder toBuilder() {
			PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PolypropyleneCommodityOther2 _that = getType().cast(o);
		
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
			return "PolypropyleneCommodityOther2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of PolypropyleneCommodityOther2  ***********************/
	class PolypropyleneCommodityOther2BuilderImpl implements PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder {
	
		protected AssetClassProductType9Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
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
		@RuneAttribute("subPdct")
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder setBasePdct(AssetClassProductType9Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public PolypropyleneCommodityOther2 build() {
			return new PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Impl(this);
		}
		
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder prune() {
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
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder o = (PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PolypropyleneCommodityOther2 _that = getType().cast(o);
		
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
			return "PolypropyleneCommodityOther2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
