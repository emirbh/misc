package iso20022.auth030.fca;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.fca.meta.AssetClassCommodityPolypropylene4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is polypropylene.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityPolypropylene4Choice__1", builder=AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityPolypropylene4Choice__1", model="iso20022", builder=AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityPolypropylene4Choice__1 extends RosettaModelObject {

	AssetClassCommodityPolypropylene4Choice__1Meta metaData = new AssetClassCommodityPolypropylene4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Plastic commodity derivative.
	 */
	PolypropyleneCommodityPlastic2__1 getPlstc();
	/**
	 * Other commodity derivative
	 */
	PolypropyleneCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityPolypropylene4Choice__1 build();
	
	AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder toBuilder();
	
	static AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder builder() {
		return new AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityPolypropylene4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityPolypropylene4Choice__1> getType() {
		return AssetClassCommodityPolypropylene4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("plstc"), processor, PolypropyleneCommodityPlastic2__1.class, getPlstc());
		processRosetta(path.newSubPath("othr"), processor, PolypropyleneCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityPolypropylene4Choice__1Builder extends AssetClassCommodityPolypropylene4Choice__1, RosettaModelObjectBuilder {
		PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder getOrCreatePlstc();
		@Override
		PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder getPlstc();
		PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder getOrCreateOthr();
		@Override
		PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder getOthr();
		AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder setPlstc(PolypropyleneCommodityPlastic2__1 plstc);
		AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder setOthr(PolypropyleneCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("plstc"), processor, PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder.class, getPlstc());
			processRosetta(path.newSubPath("othr"), processor, PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityPolypropylene4Choice__1  ***********************/
	class AssetClassCommodityPolypropylene4Choice__1Impl implements AssetClassCommodityPolypropylene4Choice__1 {
		private final PolypropyleneCommodityPlastic2__1 plstc;
		private final PolypropyleneCommodityOther2__1 othr;
		
		protected AssetClassCommodityPolypropylene4Choice__1Impl(AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder builder) {
			this.plstc = ofNullable(builder.getPlstc()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plstc")
		public PolypropyleneCommodityPlastic2__1 getPlstc() {
			return plstc;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PolypropyleneCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder toBuilder() {
			AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder builder) {
			ofNullable(getPlstc()).ifPresent(builder::setPlstc);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPolypropylene4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(plstc, _that.getPlstc())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plstc != null ? plstc.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPolypropylene4Choice__1 {" +
				"plstc=" + this.plstc + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityPolypropylene4Choice__1  ***********************/
	class AssetClassCommodityPolypropylene4Choice__1BuilderImpl implements AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder {
	
		protected PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder plstc;
		protected PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plstc")
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder getPlstc() {
			return plstc;
		}
		
		@Override
		public PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder getOrCreatePlstc() {
			PolypropyleneCommodityPlastic2__1.PolypropyleneCommodityPlastic2__1Builder result;
			if (plstc!=null) {
				result = plstc;
			}
			else {
				result = plstc = PolypropyleneCommodityPlastic2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder getOrCreateOthr() {
			PolypropyleneCommodityOther2__1.PolypropyleneCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = PolypropyleneCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("plstc")
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder setPlstc(PolypropyleneCommodityPlastic2__1 _plstc) {
			this.plstc = _plstc == null ? null : _plstc.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder setOthr(PolypropyleneCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice__1 build() {
			return new AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder prune() {
			if (plstc!=null && !plstc.prune().hasData()) plstc = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPlstc()!=null && getPlstc().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder o = (AssetClassCommodityPolypropylene4Choice__1.AssetClassCommodityPolypropylene4Choice__1Builder) other;
			
			merger.mergeRosetta(getPlstc(), o.getPlstc(), this::setPlstc);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPolypropylene4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(plstc, _that.getPlstc())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plstc != null ? plstc.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPolypropylene4Choice__1Builder {" +
				"plstc=" + this.plstc + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
