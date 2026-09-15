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
import iso20022.auth030.esma.meta.EnvironmentCommodityOther2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Other environment commodity derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="EnvironmentCommodityOther2", builder=EnvironmentCommodityOther2.EnvironmentCommodityOther2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnvironmentCommodityOther2", model="iso20022", builder=EnvironmentCommodityOther2.EnvironmentCommodityOther2BuilderImpl.class, version="${project.version}")
public interface EnvironmentCommodityOther2 extends RosettaModelObject {

	EnvironmentCommodityOther2Meta metaData = new EnvironmentCommodityOther2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType3Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnvironmentCommodityOther2 build();
	
	EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder toBuilder();
	
	static EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder builder() {
		return new EnvironmentCommodityOther2.EnvironmentCommodityOther2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentCommodityOther2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentCommodityOther2> getType() {
		return EnvironmentCommodityOther2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentCommodityOther2Builder extends EnvironmentCommodityOther2, RosettaModelObjectBuilder {
		EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder setBasePdct(AssetClassProductType3Code basePdct);
		EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType3Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder prune();
	}

	/*********************** Immutable Implementation of EnvironmentCommodityOther2  ***********************/
	class EnvironmentCommodityOther2Impl implements EnvironmentCommodityOther2 {
		private final AssetClassProductType3Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected EnvironmentCommodityOther2Impl(EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
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
		public EnvironmentCommodityOther2 build() {
			return this;
		}
		
		@Override
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder toBuilder() {
			EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentCommodityOther2 _that = getType().cast(o);
		
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
			return "EnvironmentCommodityOther2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentCommodityOther2  ***********************/
	class EnvironmentCommodityOther2BuilderImpl implements EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder {
	
		protected AssetClassProductType3Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType3Code getBasePdct() {
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
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder setBasePdct(AssetClassProductType3Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnvironmentCommodityOther2 build() {
			return new EnvironmentCommodityOther2.EnvironmentCommodityOther2Impl(this);
		}
		
		@Override
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder prune() {
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
		public EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder o = (EnvironmentCommodityOther2.EnvironmentCommodityOther2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentCommodityOther2 _that = getType().cast(o);
		
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
			return "EnvironmentCommodityOther2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
