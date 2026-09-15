package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.DerivativePartyIdentification1ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference entity of a single name credit default swap (CDS) or a derivative on single name credit default swap (CDS).
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativePartyIdentification1Choice", builder=DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativePartyIdentification1Choice", model="iso20022", builder=DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilderImpl.class, version="${project.version}")
public interface DerivativePartyIdentification1Choice extends RosettaModelObject {

	DerivativePartyIdentification1ChoiceMeta metaData = new DerivativePartyIdentification1ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Country of the reference entity.
	 */
	String getCtry();
	/**
	 * Country and country sub-division of the reference entity.
	 */
	String getCtrySubDvsn();
	/**
	 * Identification of the reference party through Legal entity identifier.
	 */
	String getLei();

	/*********************** Build Methods  ***********************/
	DerivativePartyIdentification1Choice build();
	
	DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder toBuilder();
	
	static DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder builder() {
		return new DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativePartyIdentification1Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativePartyIdentification1Choice> getType() {
		return DerivativePartyIdentification1Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ctry"), String.class, getCtry(), this);
		processor.processBasic(path.newSubPath("ctrySubDvsn"), String.class, getCtrySubDvsn(), this);
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativePartyIdentification1ChoiceBuilder extends DerivativePartyIdentification1Choice, RosettaModelObjectBuilder {
		DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setCtry(String ctry);
		DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setCtrySubDvsn(String ctrySubDvsn);
		DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setLei(String lei);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ctry"), String.class, getCtry(), this);
			processor.processBasic(path.newSubPath("ctrySubDvsn"), String.class, getCtrySubDvsn(), this);
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		}
		

		DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativePartyIdentification1Choice  ***********************/
	class DerivativePartyIdentification1ChoiceImpl implements DerivativePartyIdentification1Choice {
		private final String ctry;
		private final String ctrySubDvsn;
		private final String lei;
		
		protected DerivativePartyIdentification1ChoiceImpl(DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder builder) {
			this.ctry = builder.getCtry();
			this.ctrySubDvsn = builder.getCtrySubDvsn();
			this.lei = builder.getLei();
		}
		
		@Override
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctry")
		public String getCtry() {
			return ctry;
		}
		
		@Override
		@RosettaAttribute("ctrySubDvsn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrySubDvsn")
		public String getCtrySubDvsn() {
			return ctrySubDvsn;
		}
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		public DerivativePartyIdentification1Choice build() {
			return this;
		}
		
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder toBuilder() {
			DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder builder) {
			ofNullable(getCtry()).ifPresent(builder::setCtry);
			ofNullable(getCtrySubDvsn()).ifPresent(builder::setCtrySubDvsn);
			ofNullable(getLei()).ifPresent(builder::setLei);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativePartyIdentification1Choice _that = getType().cast(o);
		
			if (!Objects.equals(ctry, _that.getCtry())) return false;
			if (!Objects.equals(ctrySubDvsn, _that.getCtrySubDvsn())) return false;
			if (!Objects.equals(lei, _that.getLei())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctry != null ? ctry.hashCode() : 0);
			_result = 31 * _result + (ctrySubDvsn != null ? ctrySubDvsn.hashCode() : 0);
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativePartyIdentification1Choice {" +
				"ctry=" + this.ctry + ", " +
				"ctrySubDvsn=" + this.ctrySubDvsn + ", " +
				"lei=" + this.lei +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativePartyIdentification1Choice  ***********************/
	class DerivativePartyIdentification1ChoiceBuilderImpl implements DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder {
	
		protected String ctry;
		protected String ctrySubDvsn;
		protected String lei;
		
		@Override
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctry")
		public String getCtry() {
			return ctry;
		}
		
		@Override
		@RosettaAttribute("ctrySubDvsn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrySubDvsn")
		public String getCtrySubDvsn() {
			return ctrySubDvsn;
		}
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctry")
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setCtry(String _ctry) {
			this.ctry = _ctry == null ? null : _ctry;
			return this;
		}
		
		@RosettaAttribute("ctrySubDvsn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrySubDvsn")
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setCtrySubDvsn(String _ctrySubDvsn) {
			this.ctrySubDvsn = _ctrySubDvsn == null ? null : _ctrySubDvsn;
			return this;
		}
		
		@RosettaAttribute("lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lei")
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@Override
		public DerivativePartyIdentification1Choice build() {
			return new DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceImpl(this);
		}
		
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtry()!=null) return true;
			if (getCtrySubDvsn()!=null) return true;
			if (getLei()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder o = (DerivativePartyIdentification1Choice.DerivativePartyIdentification1ChoiceBuilder) other;
			
			
			merger.mergeBasic(getCtry(), o.getCtry(), this::setCtry);
			merger.mergeBasic(getCtrySubDvsn(), o.getCtrySubDvsn(), this::setCtrySubDvsn);
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativePartyIdentification1Choice _that = getType().cast(o);
		
			if (!Objects.equals(ctry, _that.getCtry())) return false;
			if (!Objects.equals(ctrySubDvsn, _that.getCtrySubDvsn())) return false;
			if (!Objects.equals(lei, _that.getLei())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctry != null ? ctry.hashCode() : 0);
			_result = 31 * _result + (ctrySubDvsn != null ? ctrySubDvsn.hashCode() : 0);
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativePartyIdentification1ChoiceBuilder {" +
				"ctry=" + this.ctry + ", " +
				"ctrySubDvsn=" + this.ctrySubDvsn + ", " +
				"lei=" + this.lei +
			'}';
		}
	}
}
