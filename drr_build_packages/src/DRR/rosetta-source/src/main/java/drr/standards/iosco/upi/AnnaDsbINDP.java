package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbINDPMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbINDP", builder=AnnaDsbINDP.AnnaDsbINDPBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbINDP", model="drr", builder=AnnaDsbINDP.AnnaDsbINDPBuilderImpl.class, version="7.7.0")
public interface AnnaDsbINDP extends RosettaModelObject {

	AnnaDsbINDPMeta metaData = new AnnaDsbINDPMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getCSTR();
	AnnaDsbEmpty getMFTG();

	/*********************** Build Methods  ***********************/
	AnnaDsbINDP build();
	
	AnnaDsbINDP.AnnaDsbINDPBuilder toBuilder();
	
	static AnnaDsbINDP.AnnaDsbINDPBuilder builder() {
		return new AnnaDsbINDP.AnnaDsbINDPBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbINDP> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbINDP> getType() {
		return AnnaDsbINDP.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("CSTR"), processor, AnnaDsbEmpty.class, getCSTR());
		processRosetta(path.newSubPath("MFTG"), processor, AnnaDsbEmpty.class, getMFTG());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbINDPBuilder extends AnnaDsbINDP, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCSTR();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getCSTR();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateMFTG();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getMFTG();
		AnnaDsbINDP.AnnaDsbINDPBuilder setCSTR(AnnaDsbEmpty CSTR);
		AnnaDsbINDP.AnnaDsbINDPBuilder setMFTG(AnnaDsbEmpty MFTG);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("CSTR"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getCSTR());
			processRosetta(path.newSubPath("MFTG"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getMFTG());
		}
		

		AnnaDsbINDP.AnnaDsbINDPBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbINDP  ***********************/
	class AnnaDsbINDPImpl implements AnnaDsbINDP {
		private final AnnaDsbEmpty cSTR;
		private final AnnaDsbEmpty mFTG;
		
		protected AnnaDsbINDPImpl(AnnaDsbINDP.AnnaDsbINDPBuilder builder) {
			this.cSTR = ofNullable(builder.getCSTR()).map(f->f.build()).orElse(null);
			this.mFTG = ofNullable(builder.getMFTG()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("CSTR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CSTR")
		public AnnaDsbEmpty getCSTR() {
			return cSTR;
		}
		
		@Override
		@RosettaAttribute("MFTG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("MFTG")
		public AnnaDsbEmpty getMFTG() {
			return mFTG;
		}
		
		@Override
		public AnnaDsbINDP build() {
			return this;
		}
		
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder toBuilder() {
			AnnaDsbINDP.AnnaDsbINDPBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbINDP.AnnaDsbINDPBuilder builder) {
			ofNullable(getCSTR()).ifPresent(builder::setCSTR);
			ofNullable(getMFTG()).ifPresent(builder::setMFTG);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbINDP _that = getType().cast(o);
		
			if (!Objects.equals(cSTR, _that.getCSTR())) return false;
			if (!Objects.equals(mFTG, _that.getMFTG())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cSTR != null ? cSTR.hashCode() : 0);
			_result = 31 * _result + (mFTG != null ? mFTG.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbINDP {" +
				"CSTR=" + this.cSTR + ", " +
				"MFTG=" + this.mFTG +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbINDP  ***********************/
	class AnnaDsbINDPBuilderImpl implements AnnaDsbINDP.AnnaDsbINDPBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder cSTR;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder mFTG;
		
		@Override
		@RosettaAttribute("CSTR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CSTR")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getCSTR() {
			return cSTR;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCSTR() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (cSTR!=null) {
				result = cSTR;
			}
			else {
				result = cSTR = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("MFTG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("MFTG")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getMFTG() {
			return mFTG;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateMFTG() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (mFTG!=null) {
				result = mFTG;
			}
			else {
				result = mFTG = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("CSTR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CSTR")
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder setCSTR(AnnaDsbEmpty _cSTR) {
			this.cSTR = _cSTR == null ? null : _cSTR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("MFTG")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("MFTG")
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder setMFTG(AnnaDsbEmpty _mFTG) {
			this.mFTG = _mFTG == null ? null : _mFTG.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbINDP build() {
			return new AnnaDsbINDP.AnnaDsbINDPImpl(this);
		}
		
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder prune() {
			if (cSTR!=null && !cSTR.prune().hasData()) cSTR = null;
			if (mFTG!=null && !mFTG.prune().hasData()) mFTG = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCSTR()!=null && getCSTR().hasData()) return true;
			if (getMFTG()!=null && getMFTG().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbINDP.AnnaDsbINDPBuilder o = (AnnaDsbINDP.AnnaDsbINDPBuilder) other;
			
			merger.mergeRosetta(getCSTR(), o.getCSTR(), this::setCSTR);
			merger.mergeRosetta(getMFTG(), o.getMFTG(), this::setMFTG);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbINDP _that = getType().cast(o);
		
			if (!Objects.equals(cSTR, _that.getCSTR())) return false;
			if (!Objects.equals(mFTG, _that.getMFTG())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cSTR != null ? cSTR.hashCode() : 0);
			_result = 31 * _result + (mFTG != null ? mFTG.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbINDPBuilder {" +
				"CSTR=" + this.cSTR + ", " +
				"MFTG=" + this.mFTG +
			'}';
		}
	}
}
