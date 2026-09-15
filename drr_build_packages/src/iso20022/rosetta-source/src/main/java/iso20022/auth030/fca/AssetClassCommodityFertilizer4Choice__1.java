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
import iso20022.auth030.fca.meta.AssetClassCommodityFertilizer4Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is fertilizer.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityFertilizer4Choice__1", builder=AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityFertilizer4Choice__1", model="iso20022", builder=AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityFertilizer4Choice__1 extends RosettaModelObject {

	AssetClassCommodityFertilizer4Choice__1Meta metaData = new AssetClassCommodityFertilizer4Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Ammonia fertilizer commodity derivative.
	 */
	FertilizerCommodityAmmonia2__1 getAmmn();
	/**
	 * Diammonium phosphate fertilizer commodity derivative.
	 */
	FertilizerCommodityDiammoniumPhosphate2__1 getDmmnmPhspht();
	/**
	 * Potash fertilizer commodity derivative.
	 */
	FertilizerCommodityPotash2__1 getPtsh();
	/**
	 * Sulphur fertilizer commodity derivative.
	 */
	FertilizerCommoditySulphur2__1 getSlphr();
	/**
	 * Urea fertilizer commodity derivative.
	 */
	FertilizerCommodityUrea2__1 getUrea();
	/**
	 * Urea and ammonium nitrate fertilizer commodity derivative.
	 */
	FertilizerCommodityUreaAndAmmoniumNitrate2__1 getUreaAndAmmnmNtrt();
	/**
	 * Other fertilizer commodity derivative.
	 */
	FertilizerCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityFertilizer4Choice__1 build();
	
	AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder toBuilder();
	
	static AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder builder() {
		return new AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityFertilizer4Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityFertilizer4Choice__1> getType() {
		return AssetClassCommodityFertilizer4Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ammn"), processor, FertilizerCommodityAmmonia2__1.class, getAmmn());
		processRosetta(path.newSubPath("dmmnmPhspht"), processor, FertilizerCommodityDiammoniumPhosphate2__1.class, getDmmnmPhspht());
		processRosetta(path.newSubPath("ptsh"), processor, FertilizerCommodityPotash2__1.class, getPtsh());
		processRosetta(path.newSubPath("slphr"), processor, FertilizerCommoditySulphur2__1.class, getSlphr());
		processRosetta(path.newSubPath("urea"), processor, FertilizerCommodityUrea2__1.class, getUrea());
		processRosetta(path.newSubPath("ureaAndAmmnmNtrt"), processor, FertilizerCommodityUreaAndAmmoniumNitrate2__1.class, getUreaAndAmmnmNtrt());
		processRosetta(path.newSubPath("othr"), processor, FertilizerCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityFertilizer4Choice__1Builder extends AssetClassCommodityFertilizer4Choice__1, RosettaModelObjectBuilder {
		FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder getOrCreateAmmn();
		@Override
		FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder getAmmn();
		FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder getOrCreateDmmnmPhspht();
		@Override
		FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder getDmmnmPhspht();
		FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder getOrCreatePtsh();
		@Override
		FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder getPtsh();
		FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder getOrCreateSlphr();
		@Override
		FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder getSlphr();
		FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder getOrCreateUrea();
		@Override
		FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder getUrea();
		FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder getOrCreateUreaAndAmmnmNtrt();
		@Override
		FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder getUreaAndAmmnmNtrt();
		FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder getOrCreateOthr();
		@Override
		FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder getOthr();
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setAmmn(FertilizerCommodityAmmonia2__1 ammn);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setDmmnmPhspht(FertilizerCommodityDiammoniumPhosphate2__1 dmmnmPhspht);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setPtsh(FertilizerCommodityPotash2__1 ptsh);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setSlphr(FertilizerCommoditySulphur2__1 slphr);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setUrea(FertilizerCommodityUrea2__1 urea);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setUreaAndAmmnmNtrt(FertilizerCommodityUreaAndAmmoniumNitrate2__1 ureaAndAmmnmNtrt);
		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setOthr(FertilizerCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ammn"), processor, FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder.class, getAmmn());
			processRosetta(path.newSubPath("dmmnmPhspht"), processor, FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder.class, getDmmnmPhspht());
			processRosetta(path.newSubPath("ptsh"), processor, FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder.class, getPtsh());
			processRosetta(path.newSubPath("slphr"), processor, FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder.class, getSlphr());
			processRosetta(path.newSubPath("urea"), processor, FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder.class, getUrea());
			processRosetta(path.newSubPath("ureaAndAmmnmNtrt"), processor, FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder.class, getUreaAndAmmnmNtrt());
			processRosetta(path.newSubPath("othr"), processor, FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityFertilizer4Choice__1  ***********************/
	class AssetClassCommodityFertilizer4Choice__1Impl implements AssetClassCommodityFertilizer4Choice__1 {
		private final FertilizerCommodityAmmonia2__1 ammn;
		private final FertilizerCommodityDiammoniumPhosphate2__1 dmmnmPhspht;
		private final FertilizerCommodityPotash2__1 ptsh;
		private final FertilizerCommoditySulphur2__1 slphr;
		private final FertilizerCommodityUrea2__1 urea;
		private final FertilizerCommodityUreaAndAmmoniumNitrate2__1 ureaAndAmmnmNtrt;
		private final FertilizerCommodityOther2__1 othr;
		
		protected AssetClassCommodityFertilizer4Choice__1Impl(AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder builder) {
			this.ammn = ofNullable(builder.getAmmn()).map(f->f.build()).orElse(null);
			this.dmmnmPhspht = ofNullable(builder.getDmmnmPhspht()).map(f->f.build()).orElse(null);
			this.ptsh = ofNullable(builder.getPtsh()).map(f->f.build()).orElse(null);
			this.slphr = ofNullable(builder.getSlphr()).map(f->f.build()).orElse(null);
			this.urea = ofNullable(builder.getUrea()).map(f->f.build()).orElse(null);
			this.ureaAndAmmnmNtrt = ofNullable(builder.getUreaAndAmmnmNtrt()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ammn")
		public FertilizerCommodityAmmonia2__1 getAmmn() {
			return ammn;
		}
		
		@Override
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmmnmPhspht")
		public FertilizerCommodityDiammoniumPhosphate2__1 getDmmnmPhspht() {
			return dmmnmPhspht;
		}
		
		@Override
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptsh")
		public FertilizerCommodityPotash2__1 getPtsh() {
			return ptsh;
		}
		
		@Override
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("slphr")
		public FertilizerCommoditySulphur2__1 getSlphr() {
			return slphr;
		}
		
		@Override
		@RosettaAttribute("urea")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("urea")
		public FertilizerCommodityUrea2__1 getUrea() {
			return urea;
		}
		
		@Override
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		public FertilizerCommodityUreaAndAmmoniumNitrate2__1 getUreaAndAmmnmNtrt() {
			return ureaAndAmmnmNtrt;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FertilizerCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder toBuilder() {
			AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder builder) {
			ofNullable(getAmmn()).ifPresent(builder::setAmmn);
			ofNullable(getDmmnmPhspht()).ifPresent(builder::setDmmnmPhspht);
			ofNullable(getPtsh()).ifPresent(builder::setPtsh);
			ofNullable(getSlphr()).ifPresent(builder::setSlphr);
			ofNullable(getUrea()).ifPresent(builder::setUrea);
			ofNullable(getUreaAndAmmnmNtrt()).ifPresent(builder::setUreaAndAmmnmNtrt);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFertilizer4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(ammn, _that.getAmmn())) return false;
			if (!Objects.equals(dmmnmPhspht, _that.getDmmnmPhspht())) return false;
			if (!Objects.equals(ptsh, _that.getPtsh())) return false;
			if (!Objects.equals(slphr, _that.getSlphr())) return false;
			if (!Objects.equals(urea, _that.getUrea())) return false;
			if (!Objects.equals(ureaAndAmmnmNtrt, _that.getUreaAndAmmnmNtrt())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ammn != null ? ammn.hashCode() : 0);
			_result = 31 * _result + (dmmnmPhspht != null ? dmmnmPhspht.hashCode() : 0);
			_result = 31 * _result + (ptsh != null ? ptsh.hashCode() : 0);
			_result = 31 * _result + (slphr != null ? slphr.hashCode() : 0);
			_result = 31 * _result + (urea != null ? urea.hashCode() : 0);
			_result = 31 * _result + (ureaAndAmmnmNtrt != null ? ureaAndAmmnmNtrt.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFertilizer4Choice__1 {" +
				"ammn=" + this.ammn + ", " +
				"dmmnmPhspht=" + this.dmmnmPhspht + ", " +
				"ptsh=" + this.ptsh + ", " +
				"slphr=" + this.slphr + ", " +
				"urea=" + this.urea + ", " +
				"ureaAndAmmnmNtrt=" + this.ureaAndAmmnmNtrt + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityFertilizer4Choice__1  ***********************/
	class AssetClassCommodityFertilizer4Choice__1BuilderImpl implements AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder {
	
		protected FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder ammn;
		protected FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder dmmnmPhspht;
		protected FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder ptsh;
		protected FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder slphr;
		protected FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder urea;
		protected FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder ureaAndAmmnmNtrt;
		protected FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ammn")
		public FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder getAmmn() {
			return ammn;
		}
		
		@Override
		public FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder getOrCreateAmmn() {
			FertilizerCommodityAmmonia2__1.FertilizerCommodityAmmonia2__1Builder result;
			if (ammn!=null) {
				result = ammn;
			}
			else {
				result = ammn = FertilizerCommodityAmmonia2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmmnmPhspht")
		public FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder getDmmnmPhspht() {
			return dmmnmPhspht;
		}
		
		@Override
		public FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder getOrCreateDmmnmPhspht() {
			FertilizerCommodityDiammoniumPhosphate2__1.FertilizerCommodityDiammoniumPhosphate2__1Builder result;
			if (dmmnmPhspht!=null) {
				result = dmmnmPhspht;
			}
			else {
				result = dmmnmPhspht = FertilizerCommodityDiammoniumPhosphate2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptsh")
		public FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder getPtsh() {
			return ptsh;
		}
		
		@Override
		public FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder getOrCreatePtsh() {
			FertilizerCommodityPotash2__1.FertilizerCommodityPotash2__1Builder result;
			if (ptsh!=null) {
				result = ptsh;
			}
			else {
				result = ptsh = FertilizerCommodityPotash2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("slphr")
		public FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder getSlphr() {
			return slphr;
		}
		
		@Override
		public FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder getOrCreateSlphr() {
			FertilizerCommoditySulphur2__1.FertilizerCommoditySulphur2__1Builder result;
			if (slphr!=null) {
				result = slphr;
			}
			else {
				result = slphr = FertilizerCommoditySulphur2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("urea")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("urea")
		public FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder getUrea() {
			return urea;
		}
		
		@Override
		public FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder getOrCreateUrea() {
			FertilizerCommodityUrea2__1.FertilizerCommodityUrea2__1Builder result;
			if (urea!=null) {
				result = urea;
			}
			else {
				result = urea = FertilizerCommodityUrea2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		public FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder getUreaAndAmmnmNtrt() {
			return ureaAndAmmnmNtrt;
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder getOrCreateUreaAndAmmnmNtrt() {
			FertilizerCommodityUreaAndAmmoniumNitrate2__1.FertilizerCommodityUreaAndAmmoniumNitrate2__1Builder result;
			if (ureaAndAmmnmNtrt!=null) {
				result = ureaAndAmmnmNtrt;
			}
			else {
				result = ureaAndAmmnmNtrt = FertilizerCommodityUreaAndAmmoniumNitrate2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder getOrCreateOthr() {
			FertilizerCommodityOther2__1.FertilizerCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = FertilizerCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ammn")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setAmmn(FertilizerCommodityAmmonia2__1 _ammn) {
			this.ammn = _ammn == null ? null : _ammn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dmmnmPhspht")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setDmmnmPhspht(FertilizerCommodityDiammoniumPhosphate2__1 _dmmnmPhspht) {
			this.dmmnmPhspht = _dmmnmPhspht == null ? null : _dmmnmPhspht.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptsh")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setPtsh(FertilizerCommodityPotash2__1 _ptsh) {
			this.ptsh = _ptsh == null ? null : _ptsh.toBuilder();
			return this;
		}
		
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("slphr")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setSlphr(FertilizerCommoditySulphur2__1 _slphr) {
			this.slphr = _slphr == null ? null : _slphr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("urea")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("urea")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setUrea(FertilizerCommodityUrea2__1 _urea) {
			this.urea = _urea == null ? null : _urea.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setUreaAndAmmnmNtrt(FertilizerCommodityUreaAndAmmoniumNitrate2__1 _ureaAndAmmnmNtrt) {
			this.ureaAndAmmnmNtrt = _ureaAndAmmnmNtrt == null ? null : _ureaAndAmmnmNtrt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder setOthr(FertilizerCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice__1 build() {
			return new AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder prune() {
			if (ammn!=null && !ammn.prune().hasData()) ammn = null;
			if (dmmnmPhspht!=null && !dmmnmPhspht.prune().hasData()) dmmnmPhspht = null;
			if (ptsh!=null && !ptsh.prune().hasData()) ptsh = null;
			if (slphr!=null && !slphr.prune().hasData()) slphr = null;
			if (urea!=null && !urea.prune().hasData()) urea = null;
			if (ureaAndAmmnmNtrt!=null && !ureaAndAmmnmNtrt.prune().hasData()) ureaAndAmmnmNtrt = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmmn()!=null && getAmmn().hasData()) return true;
			if (getDmmnmPhspht()!=null && getDmmnmPhspht().hasData()) return true;
			if (getPtsh()!=null && getPtsh().hasData()) return true;
			if (getSlphr()!=null && getSlphr().hasData()) return true;
			if (getUrea()!=null && getUrea().hasData()) return true;
			if (getUreaAndAmmnmNtrt()!=null && getUreaAndAmmnmNtrt().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder o = (AssetClassCommodityFertilizer4Choice__1.AssetClassCommodityFertilizer4Choice__1Builder) other;
			
			merger.mergeRosetta(getAmmn(), o.getAmmn(), this::setAmmn);
			merger.mergeRosetta(getDmmnmPhspht(), o.getDmmnmPhspht(), this::setDmmnmPhspht);
			merger.mergeRosetta(getPtsh(), o.getPtsh(), this::setPtsh);
			merger.mergeRosetta(getSlphr(), o.getSlphr(), this::setSlphr);
			merger.mergeRosetta(getUrea(), o.getUrea(), this::setUrea);
			merger.mergeRosetta(getUreaAndAmmnmNtrt(), o.getUreaAndAmmnmNtrt(), this::setUreaAndAmmnmNtrt);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFertilizer4Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(ammn, _that.getAmmn())) return false;
			if (!Objects.equals(dmmnmPhspht, _that.getDmmnmPhspht())) return false;
			if (!Objects.equals(ptsh, _that.getPtsh())) return false;
			if (!Objects.equals(slphr, _that.getSlphr())) return false;
			if (!Objects.equals(urea, _that.getUrea())) return false;
			if (!Objects.equals(ureaAndAmmnmNtrt, _that.getUreaAndAmmnmNtrt())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ammn != null ? ammn.hashCode() : 0);
			_result = 31 * _result + (dmmnmPhspht != null ? dmmnmPhspht.hashCode() : 0);
			_result = 31 * _result + (ptsh != null ? ptsh.hashCode() : 0);
			_result = 31 * _result + (slphr != null ? slphr.hashCode() : 0);
			_result = 31 * _result + (urea != null ? urea.hashCode() : 0);
			_result = 31 * _result + (ureaAndAmmnmNtrt != null ? ureaAndAmmnmNtrt.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFertilizer4Choice__1Builder {" +
				"ammn=" + this.ammn + ", " +
				"dmmnmPhspht=" + this.dmmnmPhspht + ", " +
				"ptsh=" + this.ptsh + ", " +
				"slphr=" + this.slphr + ", " +
				"urea=" + this.urea + ", " +
				"ureaAndAmmnmNtrt=" + this.ureaAndAmmnmNtrt + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
