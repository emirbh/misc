package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.TradeReport32Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Position/transaction reporting under the local regulation.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReport32Choice__1", builder=TradeReport32Choice__1.TradeReport32Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReport32Choice__1", model="iso20022", builder=TradeReport32Choice__1.TradeReport32Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeReport32Choice__1 extends RosettaModelObject {

	TradeReport32Choice__1Meta metaData = new TradeReport32Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether transaction is reported for the first time.
	 */
	TradeData42__1 getNew();
	/**
	 * Indicates a modification to the terms or details of a previously reported transaction, but not a correction.
	 */
	TradeData42__2 getMod();
	/**
	 * Indicates that the report is correcting the erroneous data fields of a previously submitted report.
	 */
	TradeData42__3 getCrrctn();
	/**
	 * Indicates that reported transaction is a termination or an early termination of an existing contract.
	 */
	TradeData42__4 getTermntn();
	/**
	 * Indicates a derivative contract that is to be reported as a new trade and also included in a separate position report on the same day.
	 */
	TradeData42__5 getPosCmpnt();
	/**
	 * Indicates an update of a contract valuation or collateral.
	 */
	TradeData42__6 getValtnUpd();
	/**
	 * Indicates a cancellation of a wrongly submitted entire report in case the contract never came into existence or was not subject to reporting requirements but was reported to a trade repository by mistake or a cancellation of duplicate report.
	 */
	TradeData42__7 getErr();
	/**
	 * Re-opening of a derivative, at a trade or position level, that was cancelled with action type ‘Error’ or terminated by mistake.
	 */
	TradeData42__3 getRvv();

	/*********************** Build Methods  ***********************/
	TradeReport32Choice__1 build();
	
	TradeReport32Choice__1.TradeReport32Choice__1Builder toBuilder();
	
	static TradeReport32Choice__1.TradeReport32Choice__1Builder builder() {
		return new TradeReport32Choice__1.TradeReport32Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReport32Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReport32Choice__1> getType() {
		return TradeReport32Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("new"), processor, TradeData42__1.class, getNew());
		processRosetta(path.newSubPath("mod"), processor, TradeData42__2.class, getMod());
		processRosetta(path.newSubPath("crrctn"), processor, TradeData42__3.class, getCrrctn());
		processRosetta(path.newSubPath("termntn"), processor, TradeData42__4.class, getTermntn());
		processRosetta(path.newSubPath("posCmpnt"), processor, TradeData42__5.class, getPosCmpnt());
		processRosetta(path.newSubPath("valtnUpd"), processor, TradeData42__6.class, getValtnUpd());
		processRosetta(path.newSubPath("err"), processor, TradeData42__7.class, getErr());
		processRosetta(path.newSubPath("rvv"), processor, TradeData42__3.class, getRvv());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReport32Choice__1Builder extends TradeReport32Choice__1, RosettaModelObjectBuilder {
		TradeData42__1.TradeData42__1Builder getOrCreateNew();
		@Override
		TradeData42__1.TradeData42__1Builder getNew();
		TradeData42__2.TradeData42__2Builder getOrCreateMod();
		@Override
		TradeData42__2.TradeData42__2Builder getMod();
		TradeData42__3.TradeData42__3Builder getOrCreateCrrctn();
		@Override
		TradeData42__3.TradeData42__3Builder getCrrctn();
		TradeData42__4.TradeData42__4Builder getOrCreateTermntn();
		@Override
		TradeData42__4.TradeData42__4Builder getTermntn();
		TradeData42__5.TradeData42__5Builder getOrCreatePosCmpnt();
		@Override
		TradeData42__5.TradeData42__5Builder getPosCmpnt();
		TradeData42__6.TradeData42__6Builder getOrCreateValtnUpd();
		@Override
		TradeData42__6.TradeData42__6Builder getValtnUpd();
		TradeData42__7.TradeData42__7Builder getOrCreateErr();
		@Override
		TradeData42__7.TradeData42__7Builder getErr();
		TradeData42__3.TradeData42__3Builder getOrCreateRvv();
		@Override
		TradeData42__3.TradeData42__3Builder getRvv();
		TradeReport32Choice__1.TradeReport32Choice__1Builder setNew(TradeData42__1 _new);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setMod(TradeData42__2 mod);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setCrrctn(TradeData42__3 crrctn);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setTermntn(TradeData42__4 termntn);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setPosCmpnt(TradeData42__5 posCmpnt);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setValtnUpd(TradeData42__6 valtnUpd);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setErr(TradeData42__7 err);
		TradeReport32Choice__1.TradeReport32Choice__1Builder setRvv(TradeData42__3 rvv);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("new"), processor, TradeData42__1.TradeData42__1Builder.class, getNew());
			processRosetta(path.newSubPath("mod"), processor, TradeData42__2.TradeData42__2Builder.class, getMod());
			processRosetta(path.newSubPath("crrctn"), processor, TradeData42__3.TradeData42__3Builder.class, getCrrctn());
			processRosetta(path.newSubPath("termntn"), processor, TradeData42__4.TradeData42__4Builder.class, getTermntn());
			processRosetta(path.newSubPath("posCmpnt"), processor, TradeData42__5.TradeData42__5Builder.class, getPosCmpnt());
			processRosetta(path.newSubPath("valtnUpd"), processor, TradeData42__6.TradeData42__6Builder.class, getValtnUpd());
			processRosetta(path.newSubPath("err"), processor, TradeData42__7.TradeData42__7Builder.class, getErr());
			processRosetta(path.newSubPath("rvv"), processor, TradeData42__3.TradeData42__3Builder.class, getRvv());
		}
		

		TradeReport32Choice__1.TradeReport32Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeReport32Choice__1  ***********************/
	class TradeReport32Choice__1Impl implements TradeReport32Choice__1 {
		private final TradeData42__1 _new;
		private final TradeData42__2 mod;
		private final TradeData42__3 crrctn;
		private final TradeData42__4 termntn;
		private final TradeData42__5 posCmpnt;
		private final TradeData42__6 valtnUpd;
		private final TradeData42__7 err;
		private final TradeData42__3 rvv;
		
		protected TradeReport32Choice__1Impl(TradeReport32Choice__1.TradeReport32Choice__1Builder builder) {
			this._new = ofNullable(builder.getNew()).map(f->f.build()).orElse(null);
			this.mod = ofNullable(builder.getMod()).map(f->f.build()).orElse(null);
			this.crrctn = ofNullable(builder.getCrrctn()).map(f->f.build()).orElse(null);
			this.termntn = ofNullable(builder.getTermntn()).map(f->f.build()).orElse(null);
			this.posCmpnt = ofNullable(builder.getPosCmpnt()).map(f->f.build()).orElse(null);
			this.valtnUpd = ofNullable(builder.getValtnUpd()).map(f->f.build()).orElse(null);
			this.err = ofNullable(builder.getErr()).map(f->f.build()).orElse(null);
			this.rvv = ofNullable(builder.getRvv()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public TradeData42__1 getNew() {
			return _new;
		}
		
		@Override
		@RosettaAttribute("mod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mod")
		public TradeData42__2 getMod() {
			return mod;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public TradeData42__3 getCrrctn() {
			return crrctn;
		}
		
		@Override
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termntn")
		public TradeData42__4 getTermntn() {
			return termntn;
		}
		
		@Override
		@RosettaAttribute("posCmpnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("posCmpnt")
		public TradeData42__5 getPosCmpnt() {
			return posCmpnt;
		}
		
		@Override
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtnUpd")
		public TradeData42__6 getValtnUpd() {
			return valtnUpd;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public TradeData42__7 getErr() {
			return err;
		}
		
		@Override
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rvv")
		public TradeData42__3 getRvv() {
			return rvv;
		}
		
		@Override
		public TradeReport32Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder toBuilder() {
			TradeReport32Choice__1.TradeReport32Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReport32Choice__1.TradeReport32Choice__1Builder builder) {
			ofNullable(getNew()).ifPresent(builder::setNew);
			ofNullable(getMod()).ifPresent(builder::setMod);
			ofNullable(getCrrctn()).ifPresent(builder::setCrrctn);
			ofNullable(getTermntn()).ifPresent(builder::setTermntn);
			ofNullable(getPosCmpnt()).ifPresent(builder::setPosCmpnt);
			ofNullable(getValtnUpd()).ifPresent(builder::setValtnUpd);
			ofNullable(getErr()).ifPresent(builder::setErr);
			ofNullable(getRvv()).ifPresent(builder::setRvv);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport32Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mod, _that.getMod())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			if (!Objects.equals(termntn, _that.getTermntn())) return false;
			if (!Objects.equals(posCmpnt, _that.getPosCmpnt())) return false;
			if (!Objects.equals(valtnUpd, _that.getValtnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(rvv, _that.getRvv())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mod != null ? mod.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			_result = 31 * _result + (termntn != null ? termntn.hashCode() : 0);
			_result = 31 * _result + (posCmpnt != null ? posCmpnt.hashCode() : 0);
			_result = 31 * _result + (valtnUpd != null ? valtnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (rvv != null ? rvv.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport32Choice__1 {" +
				"new=" + this._new + ", " +
				"mod=" + this.mod + ", " +
				"crrctn=" + this.crrctn + ", " +
				"termntn=" + this.termntn + ", " +
				"posCmpnt=" + this.posCmpnt + ", " +
				"valtnUpd=" + this.valtnUpd + ", " +
				"err=" + this.err + ", " +
				"rvv=" + this.rvv +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReport32Choice__1  ***********************/
	class TradeReport32Choice__1BuilderImpl implements TradeReport32Choice__1.TradeReport32Choice__1Builder {
	
		protected TradeData42__1.TradeData42__1Builder _new;
		protected TradeData42__2.TradeData42__2Builder mod;
		protected TradeData42__3.TradeData42__3Builder crrctn;
		protected TradeData42__4.TradeData42__4Builder termntn;
		protected TradeData42__5.TradeData42__5Builder posCmpnt;
		protected TradeData42__6.TradeData42__6Builder valtnUpd;
		protected TradeData42__7.TradeData42__7Builder err;
		protected TradeData42__3.TradeData42__3Builder rvv;
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public TradeData42__1.TradeData42__1Builder getNew() {
			return _new;
		}
		
		@Override
		public TradeData42__1.TradeData42__1Builder getOrCreateNew() {
			TradeData42__1.TradeData42__1Builder result;
			if (_new!=null) {
				result = _new;
			}
			else {
				result = _new = TradeData42__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mod")
		public TradeData42__2.TradeData42__2Builder getMod() {
			return mod;
		}
		
		@Override
		public TradeData42__2.TradeData42__2Builder getOrCreateMod() {
			TradeData42__2.TradeData42__2Builder result;
			if (mod!=null) {
				result = mod;
			}
			else {
				result = mod = TradeData42__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public TradeData42__3.TradeData42__3Builder getCrrctn() {
			return crrctn;
		}
		
		@Override
		public TradeData42__3.TradeData42__3Builder getOrCreateCrrctn() {
			TradeData42__3.TradeData42__3Builder result;
			if (crrctn!=null) {
				result = crrctn;
			}
			else {
				result = crrctn = TradeData42__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termntn")
		public TradeData42__4.TradeData42__4Builder getTermntn() {
			return termntn;
		}
		
		@Override
		public TradeData42__4.TradeData42__4Builder getOrCreateTermntn() {
			TradeData42__4.TradeData42__4Builder result;
			if (termntn!=null) {
				result = termntn;
			}
			else {
				result = termntn = TradeData42__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("posCmpnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("posCmpnt")
		public TradeData42__5.TradeData42__5Builder getPosCmpnt() {
			return posCmpnt;
		}
		
		@Override
		public TradeData42__5.TradeData42__5Builder getOrCreatePosCmpnt() {
			TradeData42__5.TradeData42__5Builder result;
			if (posCmpnt!=null) {
				result = posCmpnt;
			}
			else {
				result = posCmpnt = TradeData42__5.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtnUpd")
		public TradeData42__6.TradeData42__6Builder getValtnUpd() {
			return valtnUpd;
		}
		
		@Override
		public TradeData42__6.TradeData42__6Builder getOrCreateValtnUpd() {
			TradeData42__6.TradeData42__6Builder result;
			if (valtnUpd!=null) {
				result = valtnUpd;
			}
			else {
				result = valtnUpd = TradeData42__6.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public TradeData42__7.TradeData42__7Builder getErr() {
			return err;
		}
		
		@Override
		public TradeData42__7.TradeData42__7Builder getOrCreateErr() {
			TradeData42__7.TradeData42__7Builder result;
			if (err!=null) {
				result = err;
			}
			else {
				result = err = TradeData42__7.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rvv")
		public TradeData42__3.TradeData42__3Builder getRvv() {
			return rvv;
		}
		
		@Override
		public TradeData42__3.TradeData42__3Builder getOrCreateRvv() {
			TradeData42__3.TradeData42__3Builder result;
			if (rvv!=null) {
				result = rvv;
			}
			else {
				result = rvv = TradeData42__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("new")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("new")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setNew(TradeData42__1 __new) {
			this._new = __new == null ? null : __new.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mod")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setMod(TradeData42__2 _mod) {
			this.mod = _mod == null ? null : _mod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crrctn")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setCrrctn(TradeData42__3 _crrctn) {
			this.crrctn = _crrctn == null ? null : _crrctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termntn")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setTermntn(TradeData42__4 _termntn) {
			this.termntn = _termntn == null ? null : _termntn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("posCmpnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("posCmpnt")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setPosCmpnt(TradeData42__5 _posCmpnt) {
			this.posCmpnt = _posCmpnt == null ? null : _posCmpnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valtnUpd")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setValtnUpd(TradeData42__6 _valtnUpd) {
			this.valtnUpd = _valtnUpd == null ? null : _valtnUpd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("err")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("err")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setErr(TradeData42__7 _err) {
			this.err = _err == null ? null : _err.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rvv")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder setRvv(TradeData42__3 _rvv) {
			this.rvv = _rvv == null ? null : _rvv.toBuilder();
			return this;
		}
		
		@Override
		public TradeReport32Choice__1 build() {
			return new TradeReport32Choice__1.TradeReport32Choice__1Impl(this);
		}
		
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder prune() {
			if (_new!=null && !_new.prune().hasData()) _new = null;
			if (mod!=null && !mod.prune().hasData()) mod = null;
			if (crrctn!=null && !crrctn.prune().hasData()) crrctn = null;
			if (termntn!=null && !termntn.prune().hasData()) termntn = null;
			if (posCmpnt!=null && !posCmpnt.prune().hasData()) posCmpnt = null;
			if (valtnUpd!=null && !valtnUpd.prune().hasData()) valtnUpd = null;
			if (err!=null && !err.prune().hasData()) err = null;
			if (rvv!=null && !rvv.prune().hasData()) rvv = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNew()!=null && getNew().hasData()) return true;
			if (getMod()!=null && getMod().hasData()) return true;
			if (getCrrctn()!=null && getCrrctn().hasData()) return true;
			if (getTermntn()!=null && getTermntn().hasData()) return true;
			if (getPosCmpnt()!=null && getPosCmpnt().hasData()) return true;
			if (getValtnUpd()!=null && getValtnUpd().hasData()) return true;
			if (getErr()!=null && getErr().hasData()) return true;
			if (getRvv()!=null && getRvv().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport32Choice__1.TradeReport32Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReport32Choice__1.TradeReport32Choice__1Builder o = (TradeReport32Choice__1.TradeReport32Choice__1Builder) other;
			
			merger.mergeRosetta(getNew(), o.getNew(), this::setNew);
			merger.mergeRosetta(getMod(), o.getMod(), this::setMod);
			merger.mergeRosetta(getCrrctn(), o.getCrrctn(), this::setCrrctn);
			merger.mergeRosetta(getTermntn(), o.getTermntn(), this::setTermntn);
			merger.mergeRosetta(getPosCmpnt(), o.getPosCmpnt(), this::setPosCmpnt);
			merger.mergeRosetta(getValtnUpd(), o.getValtnUpd(), this::setValtnUpd);
			merger.mergeRosetta(getErr(), o.getErr(), this::setErr);
			merger.mergeRosetta(getRvv(), o.getRvv(), this::setRvv);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport32Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mod, _that.getMod())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			if (!Objects.equals(termntn, _that.getTermntn())) return false;
			if (!Objects.equals(posCmpnt, _that.getPosCmpnt())) return false;
			if (!Objects.equals(valtnUpd, _that.getValtnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(rvv, _that.getRvv())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mod != null ? mod.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			_result = 31 * _result + (termntn != null ? termntn.hashCode() : 0);
			_result = 31 * _result + (posCmpnt != null ? posCmpnt.hashCode() : 0);
			_result = 31 * _result + (valtnUpd != null ? valtnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (rvv != null ? rvv.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport32Choice__1Builder {" +
				"new=" + this._new + ", " +
				"mod=" + this.mod + ", " +
				"crrctn=" + this.crrctn + ", " +
				"termntn=" + this.termntn + ", " +
				"posCmpnt=" + this.posCmpnt + ", " +
				"valtnUpd=" + this.valtnUpd + ", " +
				"err=" + this.err + ", " +
				"rvv=" + this.rvv +
			'}';
		}
	}
}
