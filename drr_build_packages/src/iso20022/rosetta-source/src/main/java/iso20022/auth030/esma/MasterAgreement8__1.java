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
import iso20022.auth030.esma.meta.MasterAgreement8__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to a master agreement.
 * @version ${project.version}
 */
@RosettaDataType(value="MasterAgreement8__1", builder=MasterAgreement8__1.MasterAgreement8__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MasterAgreement8__1", model="iso20022", builder=MasterAgreement8__1.MasterAgreement8__1BuilderImpl.class, version="${project.version}")
public interface MasterAgreement8__1 extends RosettaModelObject {

	MasterAgreement8__1Meta metaData = new MasterAgreement8__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to any master agreement, if existent (such as ISDA Master Agreement; Master Power Purchase and Sale Agreement; International ForEx Master Agreement; European Master Agreement or any local Master Agreements).
	 */
	AgreementType2Choice__1 getTp();
	/**
	 * Reference to the year of the master agreement version used for the reported trade, if applicable (such as 1992, 2002, etc).
	 */
	String getVrsn();
	/**
	 * Additional information specifying the other type of the master agreement.
	 */
	String getOthrMstrAgrmtDtls();

	/*********************** Build Methods  ***********************/
	MasterAgreement8__1 build();
	
	MasterAgreement8__1.MasterAgreement8__1Builder toBuilder();
	
	static MasterAgreement8__1.MasterAgreement8__1Builder builder() {
		return new MasterAgreement8__1.MasterAgreement8__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreement8__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreement8__1> getType() {
		return MasterAgreement8__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tp"), processor, AgreementType2Choice__1.class, getTp());
		processor.processBasic(path.newSubPath("vrsn"), String.class, getVrsn(), this);
		processor.processBasic(path.newSubPath("othrMstrAgrmtDtls"), String.class, getOthrMstrAgrmtDtls(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreement8__1Builder extends MasterAgreement8__1, RosettaModelObjectBuilder {
		AgreementType2Choice__1.AgreementType2Choice__1Builder getOrCreateTp();
		@Override
		AgreementType2Choice__1.AgreementType2Choice__1Builder getTp();
		MasterAgreement8__1.MasterAgreement8__1Builder setTp(AgreementType2Choice__1 tp);
		MasterAgreement8__1.MasterAgreement8__1Builder setVrsn(String vrsn);
		MasterAgreement8__1.MasterAgreement8__1Builder setOthrMstrAgrmtDtls(String othrMstrAgrmtDtls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tp"), processor, AgreementType2Choice__1.AgreementType2Choice__1Builder.class, getTp());
			processor.processBasic(path.newSubPath("vrsn"), String.class, getVrsn(), this);
			processor.processBasic(path.newSubPath("othrMstrAgrmtDtls"), String.class, getOthrMstrAgrmtDtls(), this);
		}
		

		MasterAgreement8__1.MasterAgreement8__1Builder prune();
	}

	/*********************** Immutable Implementation of MasterAgreement8__1  ***********************/
	class MasterAgreement8__1Impl implements MasterAgreement8__1 {
		private final AgreementType2Choice__1 tp;
		private final String vrsn;
		private final String othrMstrAgrmtDtls;
		
		protected MasterAgreement8__1Impl(MasterAgreement8__1.MasterAgreement8__1Builder builder) {
			this.tp = ofNullable(builder.getTp()).map(f->f.build()).orElse(null);
			this.vrsn = builder.getVrsn();
			this.othrMstrAgrmtDtls = builder.getOthrMstrAgrmtDtls();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public AgreementType2Choice__1 getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("vrsn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vrsn")
		public String getVrsn() {
			return vrsn;
		}
		
		@Override
		@RosettaAttribute("othrMstrAgrmtDtls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrMstrAgrmtDtls")
		public String getOthrMstrAgrmtDtls() {
			return othrMstrAgrmtDtls;
		}
		
		@Override
		public MasterAgreement8__1 build() {
			return this;
		}
		
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder toBuilder() {
			MasterAgreement8__1.MasterAgreement8__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreement8__1.MasterAgreement8__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getVrsn()).ifPresent(builder::setVrsn);
			ofNullable(getOthrMstrAgrmtDtls()).ifPresent(builder::setOthrMstrAgrmtDtls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement8__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(vrsn, _that.getVrsn())) return false;
			if (!Objects.equals(othrMstrAgrmtDtls, _that.getOthrMstrAgrmtDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.hashCode() : 0);
			_result = 31 * _result + (vrsn != null ? vrsn.hashCode() : 0);
			_result = 31 * _result + (othrMstrAgrmtDtls != null ? othrMstrAgrmtDtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement8__1 {" +
				"tp=" + this.tp + ", " +
				"vrsn=" + this.vrsn + ", " +
				"othrMstrAgrmtDtls=" + this.othrMstrAgrmtDtls +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreement8__1  ***********************/
	class MasterAgreement8__1BuilderImpl implements MasterAgreement8__1.MasterAgreement8__1Builder {
	
		protected AgreementType2Choice__1.AgreementType2Choice__1Builder tp;
		protected String vrsn;
		protected String othrMstrAgrmtDtls;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public AgreementType2Choice__1.AgreementType2Choice__1Builder getTp() {
			return tp;
		}
		
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder getOrCreateTp() {
			AgreementType2Choice__1.AgreementType2Choice__1Builder result;
			if (tp!=null) {
				result = tp;
			}
			else {
				result = tp = AgreementType2Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vrsn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vrsn")
		public String getVrsn() {
			return vrsn;
		}
		
		@Override
		@RosettaAttribute("othrMstrAgrmtDtls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrMstrAgrmtDtls")
		public String getOthrMstrAgrmtDtls() {
			return othrMstrAgrmtDtls;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder setTp(AgreementType2Choice__1 _tp) {
			this.tp = _tp == null ? null : _tp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vrsn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vrsn")
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder setVrsn(String _vrsn) {
			this.vrsn = _vrsn == null ? null : _vrsn;
			return this;
		}
		
		@RosettaAttribute("othrMstrAgrmtDtls")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othrMstrAgrmtDtls")
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder setOthrMstrAgrmtDtls(String _othrMstrAgrmtDtls) {
			this.othrMstrAgrmtDtls = _othrMstrAgrmtDtls == null ? null : _othrMstrAgrmtDtls;
			return this;
		}
		
		@Override
		public MasterAgreement8__1 build() {
			return new MasterAgreement8__1.MasterAgreement8__1Impl(this);
		}
		
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder prune() {
			if (tp!=null && !tp.prune().hasData()) tp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null && getTp().hasData()) return true;
			if (getVrsn()!=null) return true;
			if (getOthrMstrAgrmtDtls()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreement8__1.MasterAgreement8__1Builder o = (MasterAgreement8__1.MasterAgreement8__1Builder) other;
			
			merger.mergeRosetta(getTp(), o.getTp(), this::setTp);
			
			merger.mergeBasic(getVrsn(), o.getVrsn(), this::setVrsn);
			merger.mergeBasic(getOthrMstrAgrmtDtls(), o.getOthrMstrAgrmtDtls(), this::setOthrMstrAgrmtDtls);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreement8__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(vrsn, _that.getVrsn())) return false;
			if (!Objects.equals(othrMstrAgrmtDtls, _that.getOthrMstrAgrmtDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.hashCode() : 0);
			_result = 31 * _result + (vrsn != null ? vrsn.hashCode() : 0);
			_result = 31 * _result + (othrMstrAgrmtDtls != null ? othrMstrAgrmtDtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement8__1Builder {" +
				"tp=" + this.tp + ", " +
				"vrsn=" + this.vrsn + ", " +
				"othrMstrAgrmtDtls=" + this.othrMstrAgrmtDtls +
			'}';
		}
	}
}
