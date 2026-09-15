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
import iso20022.auth030.hkma.tr.meta.PaperCommodityNewsprint2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of a paper derivative of type newsprint.
 * @version ${project.version}
 */
@RosettaDataType(value="PaperCommodityNewsprint2", builder=PaperCommodityNewsprint2.PaperCommodityNewsprint2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PaperCommodityNewsprint2", model="iso20022", builder=PaperCommodityNewsprint2.PaperCommodityNewsprint2BuilderImpl.class, version="${project.version}")
public interface PaperCommodityNewsprint2 extends RosettaModelObject {

	PaperCommodityNewsprint2Meta metaData = new PaperCommodityNewsprint2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType8Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType36Code getSubPdct();

	/*********************** Build Methods  ***********************/
	PaperCommodityNewsprint2 build();
	
	PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder toBuilder();
	
	static PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder builder() {
		return new PaperCommodityNewsprint2.PaperCommodityNewsprint2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaperCommodityNewsprint2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaperCommodityNewsprint2> getType() {
		return PaperCommodityNewsprint2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType36Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaperCommodityNewsprint2Builder extends PaperCommodityNewsprint2, RosettaModelObjectBuilder {
		PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder setBasePdct(AssetClassProductType8Code basePdct);
		PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder setSubPdct(AssetClassSubProductType36Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType8Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType36Code.class, getSubPdct(), this);
		}
		

		PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder prune();
	}

	/*********************** Immutable Implementation of PaperCommodityNewsprint2  ***********************/
	class PaperCommodityNewsprint2Impl implements PaperCommodityNewsprint2 {
		private final AssetClassProductType8Code basePdct;
		private final AssetClassSubProductType36Code subPdct;
		
		protected PaperCommodityNewsprint2Impl(PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType8Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType36Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public PaperCommodityNewsprint2 build() {
			return this;
		}
		
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder toBuilder() {
			PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityNewsprint2 _that = getType().cast(o);
		
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
			return "PaperCommodityNewsprint2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of PaperCommodityNewsprint2  ***********************/
	class PaperCommodityNewsprint2BuilderImpl implements PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder {
	
		protected AssetClassProductType8Code basePdct;
		protected AssetClassSubProductType36Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType8Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType36Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder setBasePdct(AssetClassProductType8Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder setSubPdct(AssetClassSubProductType36Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public PaperCommodityNewsprint2 build() {
			return new PaperCommodityNewsprint2.PaperCommodityNewsprint2Impl(this);
		}
		
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder prune() {
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
		public PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder o = (PaperCommodityNewsprint2.PaperCommodityNewsprint2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaperCommodityNewsprint2 _that = getType().cast(o);
		
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
			return "PaperCommodityNewsprint2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
