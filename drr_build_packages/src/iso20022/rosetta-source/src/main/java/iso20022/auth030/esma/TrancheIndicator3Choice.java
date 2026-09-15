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
import iso20022.auth030.esma.meta.TrancheIndicator3ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indication whether a derivative contract is tranched.
 * @version ${project.version}
 */
@RosettaDataType(value="TrancheIndicator3Choice", builder=TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="TrancheIndicator3Choice", model="iso20022", builder=TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilderImpl.class, version="${project.version}")
public interface TrancheIndicator3Choice extends RosettaModelObject {

	TrancheIndicator3ChoiceMeta metaData = new TrancheIndicator3ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indication that derivative contract is tranched.
	 */
	Tranche3 getTrnchd();
	/**
	 * Indicates that derivative contract is untranched.
	 */
	NoReasonCode getUtrnchd();

	/*********************** Build Methods  ***********************/
	TrancheIndicator3Choice build();
	
	TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder toBuilder();
	
	static TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder builder() {
		return new TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TrancheIndicator3Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TrancheIndicator3Choice> getType() {
		return TrancheIndicator3Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trnchd"), processor, Tranche3.class, getTrnchd());
		processor.processBasic(path.newSubPath("utrnchd"), NoReasonCode.class, getUtrnchd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TrancheIndicator3ChoiceBuilder extends TrancheIndicator3Choice, RosettaModelObjectBuilder {
		Tranche3.Tranche3Builder getOrCreateTrnchd();
		@Override
		Tranche3.Tranche3Builder getTrnchd();
		TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder setTrnchd(Tranche3 trnchd);
		TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder setUtrnchd(NoReasonCode utrnchd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trnchd"), processor, Tranche3.Tranche3Builder.class, getTrnchd());
			processor.processBasic(path.newSubPath("utrnchd"), NoReasonCode.class, getUtrnchd(), this);
		}
		

		TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TrancheIndicator3Choice  ***********************/
	class TrancheIndicator3ChoiceImpl implements TrancheIndicator3Choice {
		private final Tranche3 trnchd;
		private final NoReasonCode utrnchd;
		
		protected TrancheIndicator3ChoiceImpl(TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder builder) {
			this.trnchd = ofNullable(builder.getTrnchd()).map(f->f.build()).orElse(null);
			this.utrnchd = builder.getUtrnchd();
		}
		
		@Override
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trnchd")
		public Tranche3 getTrnchd() {
			return trnchd;
		}
		
		@Override
		@RosettaAttribute("utrnchd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utrnchd")
		public NoReasonCode getUtrnchd() {
			return utrnchd;
		}
		
		@Override
		public TrancheIndicator3Choice build() {
			return this;
		}
		
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder toBuilder() {
			TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder builder) {
			ofNullable(getTrnchd()).ifPresent(builder::setTrnchd);
			ofNullable(getUtrnchd()).ifPresent(builder::setUtrnchd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TrancheIndicator3Choice _that = getType().cast(o);
		
			if (!Objects.equals(trnchd, _that.getTrnchd())) return false;
			if (!Objects.equals(utrnchd, _that.getUtrnchd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trnchd != null ? trnchd.hashCode() : 0);
			_result = 31 * _result + (utrnchd != null ? utrnchd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TrancheIndicator3Choice {" +
				"trnchd=" + this.trnchd + ", " +
				"utrnchd=" + this.utrnchd +
			'}';
		}
	}

	/*********************** Builder Implementation of TrancheIndicator3Choice  ***********************/
	class TrancheIndicator3ChoiceBuilderImpl implements TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder {
	
		protected Tranche3.Tranche3Builder trnchd;
		protected NoReasonCode utrnchd;
		
		@Override
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trnchd")
		public Tranche3.Tranche3Builder getTrnchd() {
			return trnchd;
		}
		
		@Override
		public Tranche3.Tranche3Builder getOrCreateTrnchd() {
			Tranche3.Tranche3Builder result;
			if (trnchd!=null) {
				result = trnchd;
			}
			else {
				result = trnchd = Tranche3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("utrnchd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utrnchd")
		public NoReasonCode getUtrnchd() {
			return utrnchd;
		}
		
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trnchd")
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder setTrnchd(Tranche3 _trnchd) {
			this.trnchd = _trnchd == null ? null : _trnchd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("utrnchd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("utrnchd")
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder setUtrnchd(NoReasonCode _utrnchd) {
			this.utrnchd = _utrnchd == null ? null : _utrnchd;
			return this;
		}
		
		@Override
		public TrancheIndicator3Choice build() {
			return new TrancheIndicator3Choice.TrancheIndicator3ChoiceImpl(this);
		}
		
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder prune() {
			if (trnchd!=null && !trnchd.prune().hasData()) trnchd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrnchd()!=null && getTrnchd().hasData()) return true;
			if (getUtrnchd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder o = (TrancheIndicator3Choice.TrancheIndicator3ChoiceBuilder) other;
			
			merger.mergeRosetta(getTrnchd(), o.getTrnchd(), this::setTrnchd);
			
			merger.mergeBasic(getUtrnchd(), o.getUtrnchd(), this::setUtrnchd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TrancheIndicator3Choice _that = getType().cast(o);
		
			if (!Objects.equals(trnchd, _that.getTrnchd())) return false;
			if (!Objects.equals(utrnchd, _that.getUtrnchd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trnchd != null ? trnchd.hashCode() : 0);
			_result = 31 * _result + (utrnchd != null ? utrnchd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TrancheIndicator3ChoiceBuilder {" +
				"trnchd=" + this.trnchd + ", " +
				"utrnchd=" + this.utrnchd +
			'}';
		}
	}
}
